package com.example.assignment.controllers;

import com.example.assignment.data.entities.Actor;
import com.example.assignment.dto.request.ActorUpdateDTO;
import com.example.assignment.dto.response.ActorResponseDTO;
import com.example.assignment.services.ActorService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/actor")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    List<Actor> getActors() {
        return this.actorService.getAllActors();
    }

    // @GetMapping
    // @ResponseStatus(HttpStatus.OK)
    // List<ActorResponseDTO> getActors() {
    //     return this.actorService.getAllActors();
    // }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ActorResponseDTO getActorById(@PathVariable("id") Long id) {
        return this.actorService.getActorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ActorResponseDTO createActor(@RequestBody ActorUpdateDTO dto) {
        return this.actorService.createActor(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ActorResponseDTO updateActor(@PathVariable("id") Long id, @RequestBody ActorUpdateDTO dto) {
        return this.actorService.updateActor(id, dto);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ActorResponseDTO deleteActor(@PathVariable("id") Long id) {
        return this.actorService.deleteActor(id);
    }
}
