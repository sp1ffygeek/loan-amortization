package com.loan.config;

import com.loan.models.Payment;
import com.loan.models.dto.PaymentDTO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pyada01
 */
public interface PaymentRepository extends CrudRepository<PaymentDTO, String> {
    PaymentDTO findByPaymentId(String paymentId);
    PaymentDTO save(Payment p);
}
