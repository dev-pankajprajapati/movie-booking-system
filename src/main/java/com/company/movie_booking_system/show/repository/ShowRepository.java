package com.company.movie_booking_system.show.repository;



import com.company.movie_booking_system.show.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository
        extends JpaRepository<Show, Long> {
    List<Show> findByMovieId(Long movieId);

    List<Show> findByTheatreId(Long theatreId);
}
