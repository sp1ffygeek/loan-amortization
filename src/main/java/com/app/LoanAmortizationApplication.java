package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by sp1ffygeek on 2/3/17.
 */
@SpringBootApplication
@EnableMongoRepositories("com.loan.config")
@ComponentScan(basePackages = {
        "com.loan.service.controller",
        "com.loan.util",
        "com.loan.models.dto"})
public class LoanAmortizationApplication {


    public static void main(String[] args) {
        SpringApplication.run(LoanAmortizationApplication.class, args);
    }
}
