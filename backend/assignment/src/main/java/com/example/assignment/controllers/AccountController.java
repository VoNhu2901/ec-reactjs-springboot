package com.example.assignment.controllers;

import com.example.assignment.dto.request.RegisterRequestDto;
import com.example.assignment.dto.response.AccountResponseDto;
import com.example.assignment.services.AccountService;
import com.example.assignment.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Account Resources(Get,Put,Patch)")
@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping()
    @Operation(summary = Utils.GET_LIST + Utils.ACCOUNT)
    public List<AccountResponseDto> getAllAccount() {
        return this.accountService.getAllAccount();
    }

    @GetMapping("/{id}")
    public AccountResponseDto getAccountById(@PathVariable int id) {
        return this.accountService.getAccountById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = Utils.PUT + Utils.ACCOUNT)
    public ResponseEntity<?> updateAccount(@PathVariable int id, @Valid @RequestBody RegisterRequestDto dto) {
        return this.accountService.updateAccount(id, dto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable int id) {
        return this.accountService.deleteAccount(id);
    }
}