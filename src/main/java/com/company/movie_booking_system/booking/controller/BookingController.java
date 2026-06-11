package com.company.movie_booking_system.booking.controller;


import com.company.movie_booking_system.booking.dto.BookingRequestDTO;
import com.company.movie_booking_system.booking.dto.BookingResponseDTO;
import com.company.movie_booking_system.booking.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<BookingResponseDTO> createBooking(
            @Valid @RequestBody BookingRequestDTO request
    ) {

        return ResponseEntity.ok(
                bookingService.createBooking(request)
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<BookingResponseDTO> getBookingById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                bookingService.getBookingById(id)
        );
    }

    @GetMapping("/my-bookings")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<BookingResponseDTO>> getMyBookings() {

        return ResponseEntity.ok(
                bookingService.getMyBookings()
        );
    }

    @PutMapping("/{id}/cancel")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> cancelBooking(
            @PathVariable Long id
    ) {

        bookingService.cancelBooking(id);

        return ResponseEntity.ok(
                "Booking cancelled successfully"
        );
    }
}
