package com.loan.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by sp1ffygeek
 */
public class Loans {



    private String loanId;
    private User user;
    private BigDecimal loanOriginationValue;
    private LocalDateTime loanOriginationDate;

    private int loanTenureMonths;
    private BigDecimal loanBalanceValue;
    private BigDecimal loanInterestRate;

    private LoanAmortizationSchedule loanAmortizationSchedule;

    public Loans(LoanBuilder builder) {
        this.user = user;
        this.loanOriginationValue = loanOriginationValue;
        this.loanOriginationDate = loanOriginationDate;
        this.loanTenureMonths = loanTenureMonths;
        this.loanBalanceValue = loanBalanceValue;
        this.loanInterestRate = loanInterestRate;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getLoanOriginationValue() {
        return loanOriginationValue;
    }

    public LocalDateTime getLoanOriginationDate() {
        return loanOriginationDate;
    }

    public BigDecimal getLoanBalanceValue() {
        return loanBalanceValue;
    }

    public BigDecimal getLoanInterestRate() {
        return loanInterestRate;
    }

    public LoanAmortizationSchedule getLoanAmortizationSchedule() {
        return loanAmortizationSchedule;
    }

    public int getLoanTenureMonths() {
        return loanTenureMonths;
    }

    public String getLoanId() {
        return loanId;
    }

    public static class LoanBuilder {

        private String loanId;
        private final User user;
        private final BigDecimal loanOriginationValue;
        private final LocalDateTime loanOriginationDate;
        private int loanTenureMonths;
        private final BigDecimal loanBalanceValue;
        private final BigDecimal loanInterestRate;
        private LoanAmortizationSchedule loanAmortizationSchedule;

        public LoanBuilder(User user, BigDecimal loanOriginationValue, LocalDateTime loanOriginationDate, int loanTenureMonths, BigDecimal loanBalanceValue, BigDecimal loanInterestRate) {
            this.user = user;
            this.loanOriginationValue = loanOriginationValue;
            this.loanOriginationDate = loanOriginationDate;
            this.loanTenureMonths = loanTenureMonths;
            this.loanBalanceValue = loanBalanceValue;
            this.loanInterestRate = loanInterestRate;
        }

        public Loans.LoanBuilder loanId(String loanId) {
            this.loanId = loanId;
            return this;
        }

        public Loans.LoanBuilder loanAmortizationSchedule(LoanAmortizationSchedule loanAmortizationSchedule) {
            this.loanAmortizationSchedule = loanAmortizationSchedule;
            return this;
        }
        public Loans build() {
            return new Loans(this);
        }

    }
}
