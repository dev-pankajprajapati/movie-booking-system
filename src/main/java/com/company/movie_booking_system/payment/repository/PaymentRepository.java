package com.company.movie_booking_system.payment.repository;



import com.company.movie_booking_system.booking.entity.Booking;
import com.company.movie_booking_system.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository
        extends JpaRepository<Payment, Long> {

    Optional<Payment> findByBooking(Booking booking);

    boolean existsByBooking(Booking booking);
}
