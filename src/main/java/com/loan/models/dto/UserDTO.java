package com.loan.models.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

/**
 * Created by pyada01 on 10/7/16.
 */
public class UserDTO {

    @Id
    public String id;
    @NotBlank
    public String userId;
    @NotBlank
    public String firstName;
    @NotBlank
    public String lastName;
    public int age;
    @NotBlank
    public String phone;
    public String address;

    public UserDTO(String userId, String userPassword, String firstName, String lastName, int age, String phone, String address) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }
}