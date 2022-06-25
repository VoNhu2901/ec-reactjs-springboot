package com.example.assignment.services;

import com.example.assignment.dto.request.ActorUpdateDTO;
import com.example.assignment.dto.response.ActorResponseDTO;

public interface ActorService {


    ActorResponseDTO createActor(ActorUpdateDTO dto);
}
