package com.loan.util;

import com.loan.exceptions.ResourceNotFoundException;
import com.loan.models.Payment;
import com.loan.models.dto.LoanDTO;
import com.loan.models.dto.PaymentDTO;
import com.loan.service.payload.LoanResponse;
import com.loan.service.payload.PaymentResponse;
import com.loan.service.payload.UserResponse;
import com.loan.models.Loans;
import com.loan.models.User;
import com.loan.models.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by sp1ffygeek on 10/6/16.
 */
@Component
public class LoanUtil {

    public static UserResponse getUser(UserDTO user) throws ResourceNotFoundException {
        if (null != user) {
            return new UserResponse(new UUID(0, 9), new User.UserBuilder(user.firstName, user.lastName, user.phone)
                    .age(user.age)
                    .userId(user.userId)
                    .address(user.address)
                    .build(), null);
        } else {
            throw new ResourceNotFoundException("Unable to find the user");
        }
    }

    public static LoanResponse getLoans(LoanDTO loan) throws ResourceNotFoundException {
        if (null != loan) {
            return new LoanResponse(new UUID(0, 9), new Loans.LoanBuilder(loan.user, loan.loanOriginationValue, loan.loanOriginationDate, loan.loanTenureMonths, loan.loanBalanceValue, loan.loanInterestRate)
                    .build(), null);
        } else {
            throw new ResourceNotFoundException("Unable to find the loan");
        }
    }

    public static PaymentResponse getPayments(PaymentDTO payment) throws ResourceNotFoundException {
        if (null != payment) {
            return new PaymentResponse(new UUID(0, 9), new Payment.PaymentBuilder(payment.loanId, payment.paymentValue, payment.paymentDate)
                    .build(), null);
        } else {
            throw new ResourceNotFoundException("Unable to find the payment");
        }
    }

}
