package com.user;

import com.loan.models.dto.UserDTO;
import org.junit.Test;

import static com.user.UserDTOAssert.assertThatUserDTO;

/**
 * Created by sp1ffygeek on 10/7/16.
 */
public class UserDTOTest {
    private static final String FIRST_NAME = "f";
    private static final String LAST_NAME = "l";
    private static final String PHONE = "p";
    private static final int AGE = 1;
    private static final String ADDRESS = "q";
    private static final String USER_ID = "u";
    private static final String PASSWORD = "p";


    @Test
    public void validate_UserDTPAttributes_ShouldHaveAllValues() {

        UserDTO u = new UserDTO(USER_ID, PASSWORD, FIRST_NAME, LAST_NAME, AGE, PHONE, ADDRESS);

        assertThatUserDTO(u)
                .hasFirsName(FIRST_NAME)
                .hasLastName(LAST_NAME)
                .hasPhone(PHONE)
                .hasAddress(ADDRESS)
                .hasUserId(USER_ID)
                .hasAge(AGE);
    }

    @Test
    public void validate_UserDTPAttributes_MissingFirstAndLastName() {

        UserDTO u = new UserDTO(USER_ID, PASSWORD, null, null, AGE, null, null);

        assertThatUserDTO(u)
                .hasNoFirstName()
                .hasNoLastName()
                .hasNoPhone()
                .hasNoAddress()
                .hasUserId(USER_ID)
                .hasAge(AGE);
    }

}
