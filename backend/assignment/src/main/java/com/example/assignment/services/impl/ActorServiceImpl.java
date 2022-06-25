package com.example.assignment.services.impl;

import com.example.assignment.data.entities.Actor;
import com.example.assignment.data.repositories.ActorRepository;
import com.example.assignment.dto.request.ActorUpdateDTO;
import com.example.assignment.dto.response.ActorResponseDTO;
import com.example.assignment.services.ActorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository, ModelMapper modelMapper) {
        this.actorRepository = actorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ActorResponseDTO createActor(ActorUpdateDTO dto) {
        Actor actor = modelMapper.map(dto, Actor.class);
        Actor saveActor = actorRepository.save(actor);
        return modelMapper.map(saveActor, ActorResponseDTO.class);
    }
}
