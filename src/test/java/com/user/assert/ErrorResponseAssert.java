package com.user;

import com.loan.service.payload.ErrorResponse;
import org.assertj.core.api.AbstractAssert;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sp1ffygeek on 10/7/16.
 */
public class ErrorResponseAssert extends AbstractAssert<ErrorResponseAssert, ErrorResponse> {

    private ErrorResponseAssert(ErrorResponse actual) {
        super(actual, ErrorResponseAssert.class);
    }

    static ErrorResponseAssert assertThatErrorResponse(ErrorResponse actual) {
        return new ErrorResponseAssert(actual);
    }

    public ErrorResponseAssert hasErrorCode(int expectedErrorCode) {
        isNotNull();

        int actualErrorCode = actual.getErrorCode();
        assertThat(actualErrorCode)
                .overridingErrorMessage("Expected error code to be <%s> but was <%s>",
                        expectedErrorCode,
                        actualErrorCode
                )
                .isEqualTo(expectedErrorCode);

        return this;
    }

    public ErrorResponseAssert hasErrorMessage(String expectedErrorMessage) {
        isNotNull();

        String actualErrorMessage = actual.getMessage();
        assertThat(actualErrorMessage)
                .overridingErrorMessage("Expected valid user to be <%s> but was <%s>",
                        expectedErrorMessage,
                        actualErrorMessage
                )
                .isEqualTo(expectedErrorMessage);

        return this;
    }
}
