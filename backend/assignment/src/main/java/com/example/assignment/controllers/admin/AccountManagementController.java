package com.example.assignment.controllers.admin;

import com.example.assignment.data.entities.Account;
import com.example.assignment.dto.response.AccountResponseDTO;
import com.example.assignment.services.AccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Customers Resources Management",
        description = "Permit to access / change customer's account status")
@RestController
@RequestMapping("/admin/api/v1/users")
public class AccountManagementController {
    private final AccountService accountService;

    public AccountManagementController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    List<Account> getAccounts() {
        return this.accountService.getAllAccounts();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AccountResponseDTO getAccountById(@PathVariable("id") Long id) {
        return this.accountService.getAccountById(id);
    }


//    FIX ???
    @PutMapping()
    AccountResponseDTO changeAccountStatus(@RequestBody AccountResponseDTO dto) {
        return this.accountService.changeAccountStatus(dto);
    }

}
