package com.loan.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sp1ffygeek
 */
public class Payment {
    private String loanId;
    private BigDecimal paymentValue;
    private Date paymentDate;

    public Payment(PaymentBuilder builder) {
        this.loanId = builder.loanId;
        this.paymentValue = builder.paymentValue;
        this.paymentDate = builder.paymentDate;
    }

    public String getLoanId() {
        return loanId;
    }

    public BigDecimal getPaymentValue() {
        return paymentValue;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public static class PaymentBuilder {

        private final String loanId;
        private final BigDecimal paymentValue;
        private final Date paymentDate;

        public PaymentBuilder(String loanId, BigDecimal paymentValue, Date paymentDate) {
            this.loanId = loanId;
            this.paymentValue = paymentValue;
            this.paymentDate = paymentDate;
        }

        public Payment build() {
            return new Payment(this);
        }

    }
}
