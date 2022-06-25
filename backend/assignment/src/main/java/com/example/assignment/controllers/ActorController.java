package com.example.assignment.controllers;

import com.example.assignment.dto.request.ActorUpdateDTO;
import com.example.assignment.dto.response.ActorResponseDTO;
import com.example.assignment.services.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/actor")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ActorResponseDTO createActor(@Valid @RequestBody ActorUpdateDTO dto) {
        return actorService.createActor(dto);
    }
}
