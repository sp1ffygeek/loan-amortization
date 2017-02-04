package com.loan.service.controller;

import com.loan.config.UserRepository;
import com.loan.exceptions.ResourceNotFoundException;
import com.loan.models.User;
import com.loan.service.payload.ErrorResponse;
import com.loan.service.payload.UserRequest;
import com.loan.service.payload.UserResponse;
import com.loan.util.LoanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    LoanUtil userUtil;

    @Autowired
    private UserRepository repository;

    @RequestMapping("/finduser")
    public ResponseEntity<UserResponse> findUser(@RequestParam(value = "userId", defaultValue = "") String userId) throws ResourceNotFoundException {
        return new ResponseEntity<UserResponse>(userUtil.getUser(
                repository.findByUserId(userId))
                , HttpStatus.OK);
    }

    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest) throws ResourceNotFoundException {
        LOGGER.info("Creating user entry with information: {}", userRequest);

        User u = new User.UserBuilder(userRequest.firstName, userRequest.lastName, userRequest.phone)
                .address(userRequest.address)
                .age(userRequest.age)
                .userId(userRequest.userId)
                .build();

        return new ResponseEntity<UserResponse>(userUtil.getUser(
                repository.save(u))
                , HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }
}