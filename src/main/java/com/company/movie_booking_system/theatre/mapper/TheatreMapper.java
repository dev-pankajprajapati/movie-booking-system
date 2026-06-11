package com.company.movie_booking_system.theatre.mapper;



import com.company.movie_booking_system.theatre.dto.TheatreRequestDTO;
import com.company.movie_booking_system.theatre.dto.TheatreResponseDTO;
import com.company.movie_booking_system.theatre.entity.Theatre;
import org.springframework.stereotype.Component;

@Component
public class TheatreMapper {

    public Theatre toEntity(TheatreRequestDTO dto) {

        return Theatre.builder()
                .name(dto.getName())
                .city(dto.getCity())
                .address(dto.getAddress())
                .totalSeats(dto.getTotalSeats())
                .build();
    }

    public TheatreResponseDTO toResponse(Theatre theatre) {

        return TheatreResponseDTO.builder()
                .id(theatre.getId())
                .name(theatre.getName())
                .city(theatre.getCity())
                .address(theatre.getAddress())
                .totalSeats(theatre.getTotalSeats())
                .build();
    }
}
