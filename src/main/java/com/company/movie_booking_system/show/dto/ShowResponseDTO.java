package com.company.movie_booking_system.show.dto;



import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class ShowResponseDTO {

    private Long id;

    private Long movieId;

    private String movieTitle;

    private Long theatreId;

    private String theatreName;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private BigDecimal ticketPrice;

    private Integer availableSeats;
}
