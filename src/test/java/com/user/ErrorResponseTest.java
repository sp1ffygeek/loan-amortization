package com.user;

import com.loan.service.payload.ErrorResponse;
import org.junit.Test;

import static com.user.ErrorResponseAssert.assertThatErrorResponse;

/**
 * Created by sp1ffygeek on 10/7/16.
 */
public class ErrorResponseTest {
    @Test
    public void validate_ErrorResponse_ShouldHaveErrorCodeAndMessahe() {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(200);
        response.setMessage("test message");

        assertThatErrorResponse(response)
                .hasErrorCode(200)
                .hasErrorMessage("test message");
    }
}
