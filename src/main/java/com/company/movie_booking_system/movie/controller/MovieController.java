package com.company.movie_booking_system.movie.controller;



import com.company.movie_booking_system.movie.dto.MovieRequestDTO;
import com.company.movie_booking_system.movie.dto.MovieResponseDTO;
import com.company.movie_booking_system.movie.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MovieResponseDTO> createMovie(
            @Valid @RequestBody MovieRequestDTO request
    ) {

        MovieResponseDTO response =
                movieService.createMovie(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<MovieResponseDTO> getMovieById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                movieService.getMovieById(id)
        );
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<List<MovieResponseDTO>> getAllMovies() {

        return ResponseEntity.ok(
                movieService.getAllMovies()
        );
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MovieResponseDTO> updateMovie(
            @PathVariable Long id,
            @Valid @RequestBody MovieRequestDTO request
    ) {

        return ResponseEntity.ok(
                movieService.updateMovie(id, request)
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteMovie(
            @PathVariable Long id
    ) {

        movieService.deleteMovie(id);

        return ResponseEntity.noContent().build();
    }
}