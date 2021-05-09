package io.api.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.api.entity.Payment;
import io.api.repository.PaymentRepository;

@Service
public class PaymentService {

  @Autowired
  private PaymentRepository repository;

  public Payment doPayment(Payment payment) {
	payment.setTransactionId(UUID.randomUUID().toString());
	payment.setPaymentStatus(paymentProcessing());
	return repository.save(payment);
  }

  public Payment findPaymentHistoryByOrderId(int orderId) {
	return repository.findByOrderId(orderId);
  }
  
  public String paymentProcessing() {
	// api should be third party payment gateway.
	return new Random().nextBoolean() ? "success" : "failure";
  }
}
