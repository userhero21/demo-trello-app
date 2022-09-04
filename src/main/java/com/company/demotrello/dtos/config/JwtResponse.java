package com.company.demotrello.dtos.config;

public record JwtResponse(
        String accessToken,
        String refreshToken,
        String tokenType) {
}
