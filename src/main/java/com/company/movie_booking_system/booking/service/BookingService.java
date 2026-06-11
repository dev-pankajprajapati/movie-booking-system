package com.company.movie_booking_system.booking.service;



import com.company.movie_booking_system.booking.dto.BookingRequestDTO;
import com.company.movie_booking_system.booking.dto.BookingResponseDTO;

import java.util.List;

public interface BookingService {

    BookingResponseDTO createBooking(
            BookingRequestDTO request
    );

    BookingResponseDTO getBookingById(
            Long id
    );

    List<BookingResponseDTO> getMyBookings();

    void cancelBooking(
            Long id
    );
}
