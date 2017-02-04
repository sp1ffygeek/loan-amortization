package com.user;

import com.loan.models.User;
import com.loan.service.payload.UserResponse;
import org.assertj.core.api.AbstractAssert;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sp1ffygeek on 10/7/16.
 */
public class UserResponseAssert extends AbstractAssert<UserResponseAssert, UserResponse> {

    private UserResponseAssert(UserResponse actual) {
        super(actual, UserResponseAssert.class);
    }

    static UserResponseAssert assertThatUserResponse(UserResponse actual) {
        return new UserResponseAssert(actual);
    }

    public UserResponseAssert hasTransactionId(UUID expectedTransactionId) {
        isNotNull();

        UUID actualTransactionId = actual.getTransactionId();
        assertThat(actualTransactionId)
                .overridingErrorMessage("Expected transactionId to be <%s> but was <%s>",
                        expectedTransactionId,
                        actualTransactionId
                )
                .isEqualTo(expectedTransactionId);

        return this;
    }

    public UserResponseAssert hasUser(User expectedUser) {
        isNotNull();

        User actualUser = actual.getUser();
        assertThat(actualUser)
                .overridingErrorMessage("Expected user to be <%s> but was <%s>",
                        expectedUser,
                        actualUser
                )
                .isEqualTo(expectedUser);

        return this;
    }


    public UserResponseAssert hasNoTransactionId() {
        isNotNull();

        UUID actualTransactionId = actual.getTransactionId();
        assertThat(actualTransactionId)
                .overridingErrorMessage("expected Id to be <null> but was <%s>", actualTransactionId)
                .isNull();

        return this;
    }

    public UserResponseAssert hasNoUser() {
        isNotNull();

        User actualUser = actual.getUser();
        assertThat(actualUser)
                .overridingErrorMessage("expected user to be <null> but was <%s>", actualUser)
                .isNull();

        return this;
    }

}
