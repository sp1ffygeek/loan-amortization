package com.user;

import com.loan.service.payload.UserResponse;
import org.junit.Test;

import java.util.UUID;

import static com.user.UserResponseAssert.assertThatUserResponse;

/**
 * Created by sp1ffygeek on 10/7/16.
 */
public class UserResponseTest {
    private static final String FIRST_NAME = "f";
    private static final String LAST_NAME = "l";
    private static final String PHONE = "p";
    private static final int AGE = 1;
    private static final String ADDRESS = "q";
    private static final String USER_ID = "u";
    private static final String PASSWORD = "p";

    @Test
    public void validate_UserResponse_ShouldHaveTransactionValidUserAndNoUser() {
        UserResponse u = new UserResponse(new UUID(0, 0), null, null);

        assertThatUserResponse(u)
                .hasTransactionId(new UUID(0, 0))
                .hasNoUser();
    }

}
