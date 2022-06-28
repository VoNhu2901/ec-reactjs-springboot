package com.example.assignment.services;

import java.util.List;

import javax.validation.Valid;

import com.example.assignment.data.entities.Actor;
import com.example.assignment.dto.request.ActorUpdateDTO;
import com.example.assignment.dto.response.ActorResponseDTO;

public interface ActorService {

    List<Actor> getAllActors();

    ActorResponseDTO getActorById(Long id);

    ActorResponseDTO createActor(ActorUpdateDTO dto);

    ActorResponseDTO updateActor(Long id, ActorUpdateDTO dto);

    ActorResponseDTO deleteActor(Long id);
}
