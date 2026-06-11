package com.company.movie_booking_system.movie.mapper;



import com.company.movie_booking_system.movie.dto.MovieRequestDTO;
import com.company.movie_booking_system.movie.dto.MovieResponseDTO;
import com.company.movie_booking_system.movie.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public Movie toEntity(MovieRequestDTO dto) {

        return Movie.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .duration(dto.getDuration())
                .language(dto.getLanguage())
                .genre(dto.getGenre())
                .releaseDate(dto.getReleaseDate())
                .posterUrl(dto.getPosterUrl())
                .build();
    }

    public MovieResponseDTO toResponse(Movie movie) {

        return MovieResponseDTO.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .duration(movie.getDuration())
                .language(movie.getLanguage())
                .genre(movie.getGenre())
                .releaseDate(movie.getReleaseDate())
                .posterUrl(movie.getPosterUrl())
                .build();
    }
}