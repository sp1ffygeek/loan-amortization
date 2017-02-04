package com.loan.service.controller;

import com.loan.config.LoanRepository;
import com.loan.config.UserRepository;
import com.loan.exceptions.ResourceNotFoundException;
import com.loan.models.LoanAmortizationSchedule;
import com.loan.models.Loans;
import com.loan.models.User;
import com.loan.service.payload.ErrorResponse;
import com.loan.service.payload.LoanRequest;
import com.loan.service.payload.LoanResponse;
import com.loan.util.CalculateLoanAmortication;
import com.loan.util.LoanUtil;
import com.loan.models.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class LoanController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    LoanUtil userUtil;

    @Autowired
    private LoanRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CalculateLoanAmortication calculateLoanAmortication;

    @RequestMapping("/findloan")
    public ResponseEntity<LoanResponse> findLoan(@RequestParam(value = "loanId", defaultValue = "") String loanId) throws ResourceNotFoundException {
        return new ResponseEntity<LoanResponse>(userUtil.getLoans(
                repository.findByLoanId(loanId))
                , HttpStatus.OK);
    }

    @RequestMapping(value = "/createloan", method = RequestMethod.POST)
    public ResponseEntity<LoanResponse> createLoan(@RequestBody @Valid LoanRequest request) throws ResourceNotFoundException {
        LOGGER.info("Creating loan entry with information: {}", request);

        //Fetch user using user api
        UserDTO userDTO = userRepository.findByUserId(request.userId);

        User u = new User.UserBuilder(userDTO.firstName, userDTO.lastName, userDTO.phone)
                .age(userDTO.age)
                .userId(userDTO.userId)
                .address(userDTO.address)
                .build();


        Loans l = new Loans.LoanBuilder(u, request.loanOriginationValue, request.loanOriginationDate,
                    request.loanTenureMonths,
                    request.loanBalanceValue,
                    request.loanInterestRate).loanAmortizationSchedule(calculateLoanAmortication.compute(request.loanBalanceValue,
                request.loanInterestRate, request.loanOriginationDate, request.loanTenureMonths))
                .build();


        return new ResponseEntity<LoanResponse>(userUtil.getLoans(
                repository.save(l))
                , HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }
}