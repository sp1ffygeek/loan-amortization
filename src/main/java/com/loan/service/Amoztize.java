package com.loan.service;

import com.loan.models.LoanAmortizationSchedule;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by sp1ffygeek on 2/3/17.
 */
public interface Amoztize {
   LoanAmortizationSchedule compute(BigDecimal loanBalanceValue, BigDecimal loanInterestRate, LocalDateTime loanOriginationDate, int loanTenureMonths);

}


