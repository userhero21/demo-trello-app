package com.company.demotrello.controllers.auth;

import com.company.demotrello.controllers.ApiController;
import com.company.demotrello.dtos.config.JwtResponse;
import com.company.demotrello.dtos.config.LoginRequest;
import com.company.demotrello.dtos.config.RefreshTokenRequest;
import com.company.demotrello.dtos.config.UserRegisterDTO;
import com.company.demotrello.entities.auth.AuthUser;
import com.company.demotrello.response.ApiResponse;
import com.company.demotrello.services.auth.AuthUserService;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
public class AuthUserController extends ApiController<AuthUserService> {

    protected AuthUserController(AuthUserService service) {
        super(service);
    }

    @PostMapping(value = PATH + "/auth/login", produces = "application/json")
    public ApiResponse<JwtResponse> login(@RequestBody LoginRequest loginRequest) {
        return new ApiResponse<>(service.login(loginRequest));
    }

    @GetMapping(value = PATH + "/auth/refresh", produces = "application/json")
    public ApiResponse<JwtResponse> login(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return new ApiResponse<>(service.refreshToken(refreshTokenRequest));
    }

    @PostMapping(PATH + "/auth/register")
    public ApiResponse<AuthUser> register(@Valid @RequestBody UserRegisterDTO dto) {
        return new ApiResponse<>(service.register(dto));
    }

//    @GetMapping(PATH + "/auth/activate")
//    public ApiResponse<Boolean> register(@RequestParam(name = "activation_code") String activationCode) {
//        return new ApiResponse<>(service.activateUser(activationCode));
//    }

//    @GetMapping(PATH + "/auth/me")
//    public AuthUser me() {
//        return null;
//    }
}
