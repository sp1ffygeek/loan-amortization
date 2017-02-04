package com.loan.service.payload;

import com.loan.models.Loans;

import java.util.UUID;

/**
 * Created by sp1ffygeek
 */
public class LoanResponse {
    private final UUID transactionId;
    private final Loans loans;

    private final ErrorResponse error;

    public LoanResponse(UUID transactionId, Loans loans, ErrorResponse error) {
        this.transactionId = transactionId;
        this.loans = loans;
        this.error = error;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public Loans getLoans() {
        return loans;
    }

    public ErrorResponse getError() {
        return error;
    }
}
