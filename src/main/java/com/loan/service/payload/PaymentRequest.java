package com.loan.service.payload;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sp1ffygeek
 */
public class PaymentRequest {
    public String paymentId;
    public String loanId;
    public BigDecimal paymentValue;
    public Date paymentDate;
}
