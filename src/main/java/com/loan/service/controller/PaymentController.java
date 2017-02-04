package com.loan.service.controller;

import com.loan.config.LoanRepository;
import com.loan.config.PaymentRepository;
import com.loan.exceptions.ResourceNotFoundException;
import com.loan.models.Loans;
import com.loan.models.Payment;
import com.loan.models.dto.LoanDTO;
import com.loan.models.dto.PaymentDTO;
import com.loan.service.payload.ErrorResponse;
import com.loan.service.payload.PaymentRequest;
import com.loan.service.payload.PaymentResponse;
import com.loan.util.CalculateLoanAmortication;
import com.loan.util.LoanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PaymentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    LoanUtil userUtil;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CalculateLoanAmortication calculateLoanAmortication;

    @RequestMapping("/findPayment")
    public ResponseEntity<PaymentResponse> findPayment(@RequestParam(value = "paymentId", defaultValue = "") String paymentId) throws ResourceNotFoundException {
        return new ResponseEntity<PaymentResponse>(userUtil.getPayments(
                paymentRepository.findByPaymentId(paymentId))
                , HttpStatus.OK);
    }

    @RequestMapping(value = "/createPayment", method = RequestMethod.POST)
    public ResponseEntity<PaymentResponse> createLoan(@RequestBody @Valid PaymentRequest request) throws ResourceNotFoundException {
        LOGGER.info("Creating payment entry with information: {}", request);

        //Fetch loan using user api
        LoanDTO loanDTO = loanRepository.findByLoanId(request.loanId);
        PaymentDTO paymentDTO = null;

        if(request.loanId.equalsIgnoreCase(request.loanId)){
            //Check if payment is required else throw an exception
            BigDecimal loanOutStandingValue = loanDTO.loanBalanceValue.subtract(request.paymentValue);
            if(loanOutStandingValue.compareTo( BigDecimal.ZERO) < 0){
                ErrorResponse errorResponse = new ErrorResponse();
                errorResponse.setErrorCode(1001);
                errorResponse.setMessage("Invalid Payment. Please check loan details");

                return new ResponseEntity<PaymentResponse>(new PaymentResponse(new UUID(0, 9), null, errorResponse)
                        , HttpStatus.OK);

            }

            //build and payment
            Payment p = new Payment.PaymentBuilder(loanDTO.loanId, request.paymentValue, request.paymentDate)
                    .build();

            Loans l = new Loans.LoanBuilder(loanDTO.user, loanDTO.loanOriginationValue, loanDTO.loanOriginationDate, loanDTO.loanTenureMonths,
                    loanOutStandingValue, loanDTO.loanInterestRate)
                    .loanAmortizationSchedule(calculateLoanAmortication.compute(loanDTO.loanBalanceValue,
                            loanDTO.loanInterestRate, loanDTO.loanOriginationDate, loanDTO.loanTenureMonths))
                    .build();

            paymentDTO =
                    paymentRepository.save(p);

            //save the loan
            loanRepository.save(l);

            return new ResponseEntity<PaymentResponse>(userUtil.getPayments(paymentDTO)
                    , HttpStatus.OK);
        }else{
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorCode(1002);
            errorResponse.setMessage("System Error. Please try again in sometime...");

            return new ResponseEntity<PaymentResponse>(new PaymentResponse(new UUID(0, 9), null, errorResponse)
                    , HttpStatus.OK);

        }
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }
}