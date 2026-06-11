package com.company.movie_booking_system.booking.mapper;



import com.company.movie_booking_system.booking.dto.BookingResponseDTO;
import com.company.movie_booking_system.booking.entity.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingResponseDTO toResponse(
            Booking booking
    ) {

        return BookingResponseDTO.builder()
                .bookingId(booking.getId())

                .showId(
                        booking.getShow().getId()
                )

                .movieTitle(
                        booking.getShow()
                                .getMovie()
                                .getTitle()
                )

                .theatreName(
                        booking.getShow()
                                .getTheatre()
                                .getName()
                )

                .seatCount(
                        booking.getSeatCount()
                )

                .totalAmount(
                        booking.getTotalAmount()
                )

                .status(
                        booking.getStatus()
                )

                .bookingTime(
                        booking.getBookingTime()
                )
                .build();
    }
}
