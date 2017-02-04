package com.loan.models.dto;

import com.loan.models.User;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by sp1ffygeek on 2/3/17.
 */
public class LoanDTO {
    @Id
    public String loanId;

    @NotBlank
    public String loanAmorId;

    @NotBlank
    public User user;
    @NotBlank
    public BigDecimal loanOriginationValue;

    @NotBlank
    public int loanTenureMonths;

    @NotBlank
    public LocalDateTime loanOriginationDate;
    @NotBlank
    public BigDecimal loanBalanceValue;
    @NotBlank
    public BigDecimal loanInterestRate;

    public LoanDTO(String loanId, User user, BigDecimal loanOriginationValue, LocalDateTime loanOriginationDate, int loanTenureMonths, BigDecimal loanBalanceValue, BigDecimal loanInterestRate) {
        this.loanId = loanId;
        this.user = user;
        this.loanOriginationValue = loanOriginationValue;
        this.loanOriginationDate = loanOriginationDate;
        this.loanTenureMonths = loanTenureMonths;
        this.loanBalanceValue = loanBalanceValue;
        this.loanInterestRate = loanInterestRate;
    }

}
