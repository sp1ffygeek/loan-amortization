package com.loan.service.payload;

import com.loan.models.Payment;

import java.util.UUID;

/**
 * Created by sp1ffygeek
 */
public class PaymentResponse {
    private final UUID transactionId;
    private final Payment payment;
    private final ErrorResponse error;

    public PaymentResponse(UUID transactionId, Payment payment, ErrorResponse error) {
        this.transactionId = transactionId;
        this.payment = payment;
        this.error = error;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public Payment getPayment() {
        return payment;
    }

    public ErrorResponse getError() {
        return error;
    }
}
