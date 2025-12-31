package com.arindam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arindam.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
Optional<Payment> findByOrderId(Integer orderId);
}
