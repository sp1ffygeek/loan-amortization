package com.loan.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sp1ffygeek.
 */
public class LoanAmortization {

    Date futureAmortizedPaymentDate;
    BigDecimal principalValue;

    BigDecimal monthlyPayment;
    BigDecimal principalPaid;
    BigDecimal interestPaid;
    BigDecimal balanceLoanAmount;

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public BigDecimal getPrincipalPaid() {
        return principalPaid;
    }

    public void setPrincipalPaid(BigDecimal principalPaid) {
        this.principalPaid = principalPaid;
    }

    public Date getFutureAmortizedPaymentDate() {
        return futureAmortizedPaymentDate;
    }

    public void setFutureAmortizedPaymentDate(Date futureAmortizedPaymentDate) {
        this.futureAmortizedPaymentDate = futureAmortizedPaymentDate;
    }

    public BigDecimal getPrincipalValue() {
        return principalValue;
    }

    public void setPrincipalValue(BigDecimal principalValue) {
        this.principalValue = principalValue;
    }

    public BigDecimal getInterestPaid() {
        return interestPaid;
    }

    public void setInterestPaid(BigDecimal interestPaid) {
        this.interestPaid = interestPaid;
    }

    public BigDecimal getBalanceLoanAmount() {
        return balanceLoanAmount;
    }

    public void setBalanceLoanAmount(BigDecimal balanceLoanAmount) {
        this.balanceLoanAmount = balanceLoanAmount;
    }
}
