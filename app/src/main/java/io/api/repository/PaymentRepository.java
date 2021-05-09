package io.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.api.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer>{

  Payment findByOrderId(int orderId);

}
