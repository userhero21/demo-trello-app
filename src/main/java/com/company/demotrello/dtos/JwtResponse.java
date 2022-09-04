package com.company.demotrello.dtos;

public record JwtResponse(
        String accessToken,
        String refreshToken,
        String tokenType) {
}
