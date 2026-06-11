package com.company.movie_booking_system.payment.service;



import com.company.movie_booking_system.payment.dto.PaymentRequestDTO;
import com.company.movie_booking_system.payment.dto.PaymentResponseDTO;

public interface PaymentService {

    PaymentResponseDTO makePayment(
            PaymentRequestDTO request
    );

    PaymentResponseDTO getPaymentById(
            Long id
    );
}