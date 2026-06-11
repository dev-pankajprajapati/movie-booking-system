package com.company.movie_booking_system.payment.mapper;


import com.company.movie_booking_system.payment.dto.PaymentResponseDTO;
import com.company.movie_booking_system.payment.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public PaymentResponseDTO toResponse(
            Payment payment
    ) {

        return PaymentResponseDTO.builder()
                .paymentId(payment.getId())
                .bookingId(
                        payment.getBooking().getId()
                )
                .amount(
                        payment.getAmount()
                )
                .status(
                        payment.getStatus()
                )
                .paymentTime(
                        payment.getPaymentTime()
                )
                .build();
    }
}