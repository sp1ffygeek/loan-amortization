package com.loan.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sp1ffygeek on 2/3/17.
 */
public class LoanAmortizationSchedule {

    public List getAmortizedScheduleList() {
        return amortizedScheduleList;
    }

    public void setAmortizedScheduleList(List amortizedScheduleList) {
        this.amortizedScheduleList = amortizedScheduleList;
    }

    List amortizedScheduleList = new ArrayList<LoanAmortization>();

}
