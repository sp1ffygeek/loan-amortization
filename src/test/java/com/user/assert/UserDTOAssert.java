package com.user;

import com.loan.models.dto.UserDTO;
import org.assertj.core.api.AbstractAssert;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sp1ffygeek on 10/7/16.
 */
public class UserDTOAssert extends AbstractAssert<UserDTOAssert, UserDTO> {

    private UserDTOAssert(UserDTO actual) {
        super(actual, UserDTOAssert.class);
    }

    static UserDTOAssert assertThatUserDTO(UserDTO actual) {
        return new UserDTOAssert(actual);
    }

    public UserDTOAssert hasUserId(String expectedUserName) {
        isNotNull();

        String actualUserName = actual.userId;
        assertThat(actualUserName)
                .overridingErrorMessage("Expected user name to be <%s> but was <%s>",
                        expectedUserName,
                        actualUserName
                )
                .isEqualTo(expectedUserName);

        return this;
    }

    public UserDTOAssert hasFirsName(String expectedFirstName) {
        isNotNull();

        String actualFirstName = actual.firstName;
        assertThat(actualFirstName)
                .overridingErrorMessage("Expected firstname to be <%s> but was <%s>",
                        expectedFirstName,
                        actualFirstName
                )
                .isEqualTo(expectedFirstName);

        return this;
    }

    public UserDTOAssert hasLastName(String expectedLastName) {
        isNotNull();

        String actualLastName = actual.lastName;
        assertThat(actualLastName)
                .overridingErrorMessage("Expected last name to be <%s> but was <%s>",
                        expectedLastName,
                        actualLastName
                )
                .isEqualTo(expectedLastName);

        return this;
    }

    public UserDTOAssert hasAge(int expectedAge) {
        isNotNull();

        int actualAge = actual.age;
        assertThat(actualAge)
                .overridingErrorMessage("Expected age to be <%s> but was <%s>",
                        expectedAge,
                        actualAge
                )
                .isEqualTo(expectedAge);

        return this;
    }

    public UserDTOAssert hasPhone(String expectedPhone) {
        isNotNull();

        String actualPhone = actual.phone;
        assertThat(actualPhone)
                .overridingErrorMessage("Expected phone to be <%s> but was <%s>",
                        expectedPhone,
                        actualPhone
                )
                .isEqualTo(expectedPhone);

        return this;
    }

    public UserDTOAssert hasAddress(String expectedAddress) {
        isNotNull();

        String actualAddress = actual.address;
        assertThat(actualAddress)
                .overridingErrorMessage("Expected address to be <%s> but was <%s>",
                        expectedAddress,
                        actualAddress
                )
                .isEqualTo(expectedAddress);

        return this;
    }


    public UserDTOAssert hasNoFirstName() {
        isNotNull();

        String actualFirstName = actual.firstName;
        assertThat(actualFirstName)
                .overridingErrorMessage("expected first name to be <null> but was <%s>", actualFirstName)
                .isNull();

        return this;
    }

    public UserDTOAssert hasNoLastName() {
        isNotNull();

        String actualLastName = actual.lastName;
        assertThat(actualLastName)
                .overridingErrorMessage("expected last name to be <null> but was <%s>", actualLastName)
                .isNull();

        return this;
    }

    public UserDTOAssert hasNoPhone() {
        isNotNull();

        String actualPhone = actual.phone;
        assertThat(actualPhone)
                .overridingErrorMessage("expected phone to be <null> but was <%s>", actualPhone)
                .isNull();

        return this;
    }

    public UserDTOAssert hasNoAge() {
        isNotNull();

        int actualAge = actual.age;
        assertThat(actualAge)
                .overridingErrorMessage("expected age to be <null> but was <%s>", actualAge)
                .isNull();

        return this;
    }

    public UserDTOAssert hasNoAddress() {
        isNotNull();

        String actualAddress = actual.address;
        assertThat(actualAddress)
                .overridingErrorMessage("expected address to be <null> but was <%s>", actualAddress)
                .isNull();

        return this;
    }
/*
    public UserDTOAssert hasNoId() {
        isNotNull();

        String actualId = actual.getId();
        assertThat(actualId)
                .overridingErrorMessage("Expected id to be <null> but was <%s>", actualId)
                .isNull();

        return this;
    }

    public UserDTOAssert hasTitle(String expectedTitle) {
        isNotNull();

        String actualTitle = actual.getTitle();
        assertThat(actualTitle)
                .overridingErrorMessage("Expected title to be <%s> but was <%s>",
                        expectedTitle,
                        actualTitle
                )
                .isEqualTo(expectedTitle);

        return this;
    }
    */
}
