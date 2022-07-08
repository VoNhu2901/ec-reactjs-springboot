package com.example.assignment.controllers;

import com.example.assignment.dto.request.RegisterRequestDto;
import com.example.assignment.dto.request.SignInRequestDto;
import com.example.assignment.dto.response.AuthResponseDto;
import com.example.assignment.services.AuthService;
import com.example.assignment.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/signin")
    @Operation(summary = Utils.LOGIN + Utils.ACCOUNT)
    public AuthResponseDto signIn(@RequestBody SignInRequestDto dto) {
        return this.authService.signIn(dto);
    }


    @PostMapping("/register")
    @Operation(summary = Utils.CREATE_NEW + Utils.ACCOUNT)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = Utils.CREATE_NEW + Utils.ACCOUNT + Utils.SUCCESS),
            @ApiResponse(responseCode = "404", description = Utils.NOT_FOUND + Utils.ACCOUNT)
    })
    public AuthResponseDto registerUser(@RequestBody RegisterRequestDto dto) {
        return this.authService.registerUser(dto);
    }
}
