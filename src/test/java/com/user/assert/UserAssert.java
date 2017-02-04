package com.user;

import com.loan.models.User;
import org.assertj.core.api.AbstractAssert;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sp1ffygeek on 10/7/16.
 */
public class UserAssert extends AbstractAssert<UserAssert, User> {

    private UserAssert(User actual) {
        super(actual, UserAssert.class);
    }

    static UserAssert assertThatUser(User actual) {
        return new UserAssert(actual);
    }

    public UserAssert hasUserId(String expectedUserName) {
        isNotNull();

        String actualUserName = actual.getUserId();
        assertThat(actualUserName)
                .overridingErrorMessage("Expected user name to be <%s> but was <%s>",
                        expectedUserName,
                        actualUserName
                )
                .isEqualTo(expectedUserName);

        return this;
    }

    public UserAssert hasFirsName(String expectedFirstName) {
        isNotNull();

        String actualFirstName = actual.getFirstName();
        assertThat(actualFirstName)
                .overridingErrorMessage("Expected firstname to be <%s> but was <%s>",
                        expectedFirstName,
                        actualFirstName
                )
                .isEqualTo(expectedFirstName);

        return this;
    }

    public UserAssert hasLastName(String expectedLastName) {
        isNotNull();

        String actualLastName = actual.getLastName();
        assertThat(actualLastName)
                .overridingErrorMessage("Expected last name to be <%s> but was <%s>",
                        expectedLastName,
                        actualLastName
                )
                .isEqualTo(expectedLastName);

        return this;
    }

    public UserAssert hasAge(int expectedAge) {
        isNotNull();

        int actualAge = actual.getAge();
        assertThat(actualAge)
                .overridingErrorMessage("Expected age to be <%s> but was <%s>",
                        expectedAge,
                        actualAge
                )
                .isEqualTo(expectedAge);

        return this;
    }

    public UserAssert hasPhone(String expectedPhone) {
        isNotNull();

        String actualPhone = actual.getPhone();
        assertThat(actualPhone)
                .overridingErrorMessage("Expected phone to be <%s> but was <%s>",
                        expectedPhone,
                        actualPhone
                )
                .isEqualTo(expectedPhone);

        return this;
    }

    public UserAssert hasAddress(String expectedAddress) {
        isNotNull();

        String actualAddress = actual.getAddress();
        assertThat(actualAddress)
                .overridingErrorMessage("Expected address to be <%s> but was <%s>",
                        expectedAddress,
                        actualAddress
                )
                .isEqualTo(expectedAddress);

        return this;
    }


    public UserAssert hasNoFirstName() {
        isNotNull();

        String actualFirstName = actual.getFirstName();
        assertThat(actualFirstName)
                .overridingErrorMessage("expected first name to be <null> but was <%s>", actualFirstName)
                .isNull();

        return this;
    }

    public UserAssert hasNoLastName() {
        isNotNull();

        String actualLastName = actual.getLastName();
        assertThat(actualLastName)
                .overridingErrorMessage("expected last name to be <null> but was <%s>", actualLastName)
                .isNull();

        return this;
    }

    public UserAssert hasNoPhone() {
        isNotNull();

        String actualPhone = actual.getPhone();
        assertThat(actualPhone)
                .overridingErrorMessage("expected phone to be <null> but was <%s>", actualPhone)
                .isNull();

        return this;
    }

    public UserAssert hasNoAge() {
        isNotNull();

        int actualAge = actual.getAge();
        assertThat(actualAge)
                .overridingErrorMessage("expected age to be <null> but was <%s>", actualAge)
                .isNull();

        return this;
    }

    public UserAssert hasNoAddress() {
        isNotNull();

        String actualAddress = actual.getAddress();
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
