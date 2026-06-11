package com.company.movie_booking_system.show.mapper;


import com.company.movie_booking_system.show.dto.ShowResponseDTO;
import com.company.movie_booking_system.show.entity.Show;
import org.springframework.stereotype.Component;

@Component
public class ShowMapper {

    public ShowResponseDTO toResponse(Show show) {

        return ShowResponseDTO.builder()
                .id(show.getId())

                .movieId(show.getMovie().getId())
                .movieTitle(show.getMovie().getTitle())

                .theatreId(show.getTheatre().getId())
                .theatreName(show.getTheatre().getName())

                .startTime(show.getStartTime())
                .endTime(show.getEndTime())

                .ticketPrice(show.getTicketPrice())

                .availableSeats(show.getAvailableSeats())
                .build();
    }
}