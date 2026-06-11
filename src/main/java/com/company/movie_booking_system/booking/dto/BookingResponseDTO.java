package com.company.movie_booking_system.booking.dto;



import com.company.movie_booking_system.constant.BookingStatus;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class BookingResponseDTO {

    private Long bookingId;

    private Long showId;

    private String movieTitle;

    private String theatreName;

    private Integer seatCount;

    private BigDecimal totalAmount;

    private BookingStatus status;

    private LocalDateTime bookingTime;
}