package com.example.web_proyect.controllers;


import com.example.web_proyect.dto.PublicationDTO;
import com.example.web_proyect.services.PublicationService;
import com.example.web_proyect.services.PublicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;


    @PostMapping
    public ResponseEntity<PublicationDTO> savePublication(@RequestBody PublicationDTO publicationDTO){

        return new ResponseEntity<>(publicationService.createPublication(publicationDTO), HttpStatus.CREATED);
    }

}
