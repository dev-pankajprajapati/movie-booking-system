package com.company.movie_booking_system.booking.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequestDTO {

    @NotNull(message = "Show id is required")
    private Long showId;

    @NotNull(message = "Seat count is required")
    @Min(value = 1, message = "Seat count must be at least 1")
    private Integer seatCount;
}
