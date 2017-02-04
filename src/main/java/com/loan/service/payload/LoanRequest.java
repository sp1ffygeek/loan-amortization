package com.loan.service.payload;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by sp1ffygeek
 */
public class LoanRequest {
    public String userId;
    public BigDecimal loanOriginationValue;
    public LocalDateTime loanOriginationDate;
    public int loanTenureMonths;
    public BigDecimal loanBalanceValue;
    public BigDecimal loanInterestRate;
}
