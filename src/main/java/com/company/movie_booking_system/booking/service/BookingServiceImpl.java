package com.company.movie_booking_system.booking.service;



import com.company.movie_booking_system.booking.dto.BookingRequestDTO;
import com.company.movie_booking_system.booking.dto.BookingResponseDTO;
import com.company.movie_booking_system.booking.entity.Booking;
import com.company.movie_booking_system.booking.mapper.BookingMapper;
import com.company.movie_booking_system.booking.repository.BookingRepository;
import com.company.movie_booking_system.constant.BookingStatus;
import com.company.movie_booking_system.exception.BadRequestException;
import com.company.movie_booking_system.exception.ResourceNotFoundException;
import com.company.movie_booking_system.show.entity.Show;
import com.company.movie_booking_system.show.repository.ShowRepository;
import com.company.movie_booking_system.user.entity.User;
import com.company.movie_booking_system.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;
    private final UserRepository userRepository;
    private final BookingMapper bookingMapper;

    @Override
    @Transactional
    public BookingResponseDTO createBooking(
            BookingRequestDTO request
    ) {

        User user = getCurrentUser();

        Show show = showRepository.findById(
                        request.getShowId()
                )
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Show not found with id: "
                                        + request.getShowId()
                        ));

        if (show.getAvailableSeats()
                < request.getSeatCount()) {

            throw new BadRequestException(
                    "Not enough seats available"
            );
        }

        BigDecimal totalAmount =
                show.getTicketPrice()
                        .multiply(
                                BigDecimal.valueOf(
                                        request.getSeatCount()
                                )
                        );

        show.setAvailableSeats(
                show.getAvailableSeats()
                        - request.getSeatCount()
        );

        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .seatCount(request.getSeatCount())
                .totalAmount(totalAmount)
                .status(BookingStatus.PENDING)
                .build();

        Booking savedBooking =
                bookingRepository.save(booking);

        return bookingMapper.toResponse(
                savedBooking
        );
    }

    @Override
    public BookingResponseDTO getBookingById(
            Long id
    ) {

        Booking booking =
                bookingRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Booking not found with id: "
                                                + id
                                ));

        return bookingMapper.toResponse(
                booking
        );
    }

    @Override
    public List<BookingResponseDTO> getMyBookings() {

        User user = getCurrentUser();

        return bookingRepository.findByUser(user)
                .stream()
                .map(bookingMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public void cancelBooking(
            Long id
    ) {

        Booking booking =
                bookingRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Booking not found with id: "
                                                + id
                                ));

        if (booking.getStatus()
                == BookingStatus.CANCELLED) {

            throw new BadRequestException(
                    "Booking already cancelled"
            );
        }

        Show show = booking.getShow();

        show.setAvailableSeats(
                show.getAvailableSeats()
                        + booking.getSeatCount()
        );

        booking.setStatus(
                BookingStatus.CANCELLED
        );
    }

    private User getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        String email =
                authentication.getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"
                        ));
    }
}