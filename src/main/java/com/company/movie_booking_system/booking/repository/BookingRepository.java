package com.company.movie_booking_system.booking.repository;



import com.company.movie_booking_system.booking.entity.Booking;
import com.company.movie_booking_system.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository
        extends JpaRepository<Booking, Long> {

    List<Booking> findByUser(User user);
}