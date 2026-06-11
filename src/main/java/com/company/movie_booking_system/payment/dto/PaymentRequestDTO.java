package com.company.movie_booking_system.payment.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDTO {

    @NotNull(message = "Booking id is required")
    private Long bookingId;
}