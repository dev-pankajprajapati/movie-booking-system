package com.company.movie_booking_system.auth.service;



import com.company.movie_booking_system.auth.dto.AuthResponse;
import com.company.movie_booking_system.auth.dto.LoginRequest;
import com.company.movie_booking_system.auth.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}
