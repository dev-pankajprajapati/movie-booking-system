package com.company.movie_booking_system.show.dto;



import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ShowRequestDTO {

    @NotNull(message = "Movie id is required")
    private Long movieId;

    @NotNull(message = "Theatre id is required")
    private Long theatreId;

    @NotNull(message = "Start time is required")
    private LocalDateTime startTime;

    @NotNull(message = "End time is required")
    private LocalDateTime endTime;

    @NotNull(message = "Ticket price is required")
    @DecimalMin(value = "0.01",
            message = "Ticket price must be greater than zero")
    private BigDecimal ticketPrice;
}
