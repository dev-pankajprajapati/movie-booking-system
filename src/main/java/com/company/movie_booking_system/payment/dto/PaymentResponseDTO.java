package com.company.movie_booking_system.payment.dto;



import com.company.movie_booking_system.constant.PaymentStatus;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class PaymentResponseDTO {

    private Long paymentId;

    private Long bookingId;

    private BigDecimal amount;

    private PaymentStatus status;

    private LocalDateTime paymentTime;
}