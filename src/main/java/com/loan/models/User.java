package com.loan.models;

/**
 * Created by sp1ffygeek
 */
public class User {

    private final String userId;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String phone;
    private final String address;

    public User(UserBuilder builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public static class UserBuilder {

        private final String firstName;
        private final String lastName;
        private final String phone;
        private String userId;
        private int age;
        private String address;

        public UserBuilder(String firstName, String lastName, String phone) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
        }

        public UserBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }
}
