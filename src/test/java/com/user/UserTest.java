package com.user;

import com.loan.models.User;
import org.junit.Test;

import static com.user.UserAssert.assertThatUser;

/**
 * Created by sp1ffygeek on 10/7/16.
 */
public class UserTest {
    private static final String FIRST_NAME = "f";
    private static final String LAST_NAME = "l";
    private static final String PHONE = "p";
    private static final int AGE = 1;
    private static final String ADDRESS = "q";
    private static final String USER_ID = "u";
    private static final String PASSWORD = "p";

    @Test
    public void update_MaxLengthTitleAndDescription_ShouldUpdateTitleAndDescription() {
        User u = new User.UserBuilder(FIRST_NAME, LAST_NAME, PHONE)
                .address(ADDRESS)
                .age(AGE)
                .userId(USER_ID)
                .build();

        assertThatUser(u)
                .hasFirsName(FIRST_NAME)
                .hasLastName(LAST_NAME)
                .hasPhone(PHONE)
                .hasAddress(ADDRESS)
                .hasUserId(USER_ID)
                .hasAge(AGE);
    }

}
