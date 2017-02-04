package com.loan.config;

import com.loan.models.Loans;
import com.loan.models.dto.LoanDTO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pyada01
 */
public interface LoanRepository extends CrudRepository<LoanDTO, String> {
    LoanDTO findByLoanId(String loanId);
    LoanDTO save(Loans l);
}
