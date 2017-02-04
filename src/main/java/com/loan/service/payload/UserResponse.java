package com.loan.service.payload;

import com.loan.models.User;

import java.util.UUID;

/**
 * Created by sp1ffygeek
 */
public class UserResponse {
    private final UUID transactionId;
    private final User user;
    private final ErrorResponse error;

    public UserResponse(UUID transactionId, User user, ErrorResponse error) {
        this.transactionId = transactionId;
        this.user = user;
        this.error = error;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public User getUser() {
        return user;
    }

    public ErrorResponse getError() {
        return error;
    }
}
