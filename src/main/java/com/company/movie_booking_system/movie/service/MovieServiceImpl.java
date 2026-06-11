package com.company.movie_booking_system.movie.service;



import com.company.movie_booking_system.exception.BadRequestException;
import com.company.movie_booking_system.exception.ResourceNotFoundException;
import com.company.movie_booking_system.movie.dto.MovieRequestDTO;
import com.company.movie_booking_system.movie.dto.MovieResponseDTO;
import com.company.movie_booking_system.movie.entity.Movie;
import com.company.movie_booking_system.movie.mapper.MovieMapper;
import com.company.movie_booking_system.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public MovieResponseDTO createMovie(MovieRequestDTO request) {

        if (movieRepository.existsByTitleIgnoreCase(request.getTitle())) {
            throw new BadRequestException("Movie already exists");
        }

        Movie movie = movieMapper.toEntity(request);

        Movie savedMovie = movieRepository.save(movie);

        return movieMapper.toResponse(savedMovie);
    }

    @Override
    public MovieResponseDTO getMovieById(Long id) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Movie not found with id: " + id
                        ));

        return movieMapper.toResponse(movie);
    }

    @Override
    public List<MovieResponseDTO> getAllMovies() {

        return movieRepository.findAll()
                .stream()
                .map(movieMapper::toResponse)
                .toList();
    }

    @Override
    public MovieResponseDTO updateMovie(
            Long id,
            MovieRequestDTO request
    ) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Movie not found with id: " + id
                        ));

        movie.setTitle(request.getTitle());
        movie.setDescription(request.getDescription());
        movie.setDuration(request.getDuration());
        movie.setLanguage(request.getLanguage());
        movie.setGenre(request.getGenre());
        movie.setReleaseDate(request.getReleaseDate());
        movie.setPosterUrl(request.getPosterUrl());

        Movie updatedMovie = movieRepository.save(movie);

        return movieMapper.toResponse(updatedMovie);
    }

    @Override
    public void deleteMovie(Long id) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Movie not found with id: " + id
                        ));

        movieRepository.delete(movie);
    }
}
