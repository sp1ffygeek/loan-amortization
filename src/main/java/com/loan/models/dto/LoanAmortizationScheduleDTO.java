package com.loan.models.dto;

import com.loan.models.LoanAmortization;
import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sp1ffygeek on 2/3/17.
 */
public class LoanAmortizationScheduleDTO {

    List amortizedScheduleList = new ArrayList<LoanAmortization>();

}
