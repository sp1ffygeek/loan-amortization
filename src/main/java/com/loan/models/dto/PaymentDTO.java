package com.loan.models.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sp1ffygeek
 */
public class PaymentDTO {

    public String paymentId;
    public String loanId;
    public BigDecimal paymentValue;
    public Date paymentDate;

    public PaymentDTO(String paymentId, String loanId, BigDecimal paymentValue, Date paymentDate) {
        this.paymentId = paymentId;
        this.loanId = loanId;
        this.paymentValue = paymentValue;
        this.paymentDate = paymentDate;
    }

}
