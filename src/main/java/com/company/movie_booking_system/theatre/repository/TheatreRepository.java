package com.company.movie_booking_system.theatre.repository;



import com.company.movie_booking_system.theatre.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    boolean existsByNameAndCity(
            String name,
            String city
    );
}
