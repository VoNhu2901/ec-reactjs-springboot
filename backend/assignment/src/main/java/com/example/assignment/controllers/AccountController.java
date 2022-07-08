package com.example.assignment.controllers;

import com.example.assignment.dto.request.RegisterRequestDto;
import com.example.assignment.dto.response.AccountResponseDto;
import com.example.assignment.services.AccountService;
import com.example.assignment.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping()
    @Operation(summary = Utils.GET_LIST + Utils.ACCOUNT)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = Utils.GET_LIST + Utils.ACCOUNT + Utils.SUCCESS),
            @ApiResponse(responseCode = "404", description = Utils.NOT_FOUND + Utils.ACCOUNT)
    })
    public List<AccountResponseDto> getAllAccount() {
        return this.accountService.getAllAccount();
    }

    @GetMapping("/{id}")
    @Operation(summary = Utils.GET_ONE + Utils.ACCOUNT)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = Utils.GET_ONE + Utils.ACCOUNT + Utils.SUCCESS),
            @ApiResponse(responseCode = "404", description = Utils.NOT_FOUND + Utils.ACCOUNT)
    })
    public AccountResponseDto getAccountById(@PathVariable int id) {
        return this.accountService.getAccountById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = Utils.PUT + Utils.ACCOUNT)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = Utils.PUT + Utils.ACCOUNT + Utils.SUCCESS),
            @ApiResponse(responseCode = "404", description = Utils.NOT_FOUND + Utils.ACCOUNT)
    })
    public ResponseEntity<?> updateAccount(@PathVariable int id, @Valid @RequestBody RegisterRequestDto dto) {
        return this.accountService.updateAccount(id, dto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = Utils.PATCH + Utils.ACCOUNT)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = Utils.PATCH + Utils.ACCOUNT + Utils.SUCCESS),
            @ApiResponse(responseCode = "404", description = Utils.NOT_FOUND + Utils.ACCOUNT)
    })
    public ResponseEntity<?> deleteAccount(@PathVariable int id) {
        return this.accountService.deleteAccount(id);
    }
}
