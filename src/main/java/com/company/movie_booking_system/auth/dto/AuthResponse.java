package com.company.movie_booking_system.auth.dto;

import com.company.movie_booking_system.constant.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AuthResponse {

    private String token;

    private String tokenType;

    private Long userId;

    private String name;

    private String email;

    private Role role;
}