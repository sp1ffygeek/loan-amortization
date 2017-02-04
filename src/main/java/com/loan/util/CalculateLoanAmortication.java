package com.loan.util;

import com.loan.models.LoanAmortization;
import com.loan.models.LoanAmortizationSchedule;
import com.loan.models.Loans;
import com.loan.models.dto.LoanDTO;
import com.loan.service.Amoztize;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sp1ffygeek on 2/3/17.
 */
@Component
public class CalculateLoanAmortication implements Amoztize {

    public static List<LoanAmortization> calculateAmortization(double principal, double interestRate, long numberMonths) {
        List amortizedScheduleList = new ArrayList<LoanAmortization>();
        LoanAmortization loanAmortization = null;

        double newbal;
        double im = (interestRate / numberMonths) / 100;
        double mp, ip, pp;
        int i;

        mp = principal * im * Math.pow(1 + im, (double) numberMonths) / (Math.pow(1 + im, (double) numberMonths) - 1);


        for (i = 1; i < numberMonths; i++) {
            loanAmortization = new LoanAmortization();
            ip = principal * im;        //interest paid
            pp = mp - ip;               //princial paid
            newbal = principal - pp;    //new balance

            loanAmortization.setPrincipalValue(new BigDecimal(principal));
            loanAmortization.setMonthlyPayment(new BigDecimal(mp));

            principal = newbal;         //update old balance

            loanAmortization.setPrincipalPaid(new BigDecimal(pp));
            loanAmortization.setInterestPaid(new BigDecimal(ip));
            loanAmortization.setBalanceLoanAmount(new BigDecimal(newbal));

            amortizedScheduleList.add(loanAmortization);

        }

        //last month
        pp = principal;
        ip = principal * im;
        mp = pp + ip;
        newbal = 0.0;

        loanAmortization = new LoanAmortization();
        loanAmortization.setPrincipalValue(new BigDecimal(principal));
        loanAmortization.setMonthlyPayment(new BigDecimal(mp));
        loanAmortization.setPrincipalPaid(new BigDecimal(pp));
        loanAmortization.setInterestPaid(new BigDecimal(ip));
        loanAmortization.setBalanceLoanAmount(new BigDecimal(newbal));

        return amortizedScheduleList;
    }

    @Override
    public LoanAmortizationSchedule compute(BigDecimal loanBalanceValue, BigDecimal loanInterestRate, LocalDateTime loanOriginationDate, int loanTenureMonths) {
        LoanAmortizationSchedule loanAmortizationSchedule = new LoanAmortizationSchedule();
        loanAmortizationSchedule.setAmortizedScheduleList(calculateAmortization(loanBalanceValue.doubleValue(), loanInterestRate.doubleValue(),
                ChronoUnit.MONTHS.between(LocalDateTime.now().toLocalDate(), (loanOriginationDate.plusMonths(loanTenureMonths)))));

        return loanAmortizationSchedule;
    }
}
