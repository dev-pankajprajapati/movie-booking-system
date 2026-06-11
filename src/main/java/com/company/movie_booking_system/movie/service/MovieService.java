package com.company.movie_booking_system.movie.service;


import com.company.movie_booking_system.movie.dto.MovieRequestDTO;
import com.company.movie_booking_system.movie.dto.MovieResponseDTO;

import java.util.List;

public interface MovieService {

    MovieResponseDTO createMovie(MovieRequestDTO request);

    MovieResponseDTO getMovieById(Long id);

    List<MovieResponseDTO> getAllMovies();

    MovieResponseDTO updateMovie(Long id, MovieRequestDTO request);

    void deleteMovie(Long id);
}
