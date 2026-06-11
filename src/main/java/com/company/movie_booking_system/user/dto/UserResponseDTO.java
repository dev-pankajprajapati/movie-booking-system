package com.company.movie_booking_system.user.dto;

import com.company.movie_booking_system.constant.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponseDTO {

    private Long id;

    private String name;

    private String email;

    private Role role;
}


