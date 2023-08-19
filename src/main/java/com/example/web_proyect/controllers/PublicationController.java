package com.example.web_proyect.controllers;


import com.example.web_proyect.dto.PublicationDTO;
import com.example.web_proyect.entities.Publication;
import com.example.web_proyect.services.PublicationService;
import com.example.web_proyect.services.PublicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;



    @GetMapping
    public List<PublicationDTO> listarPublicaciones(@RequestParam(value = "pageNo",defaultValue = "0", required = false) int numeroDePagina,@RequestParam(value = "pageSize",defaultValue = "10",required = false) int medidaPagina){
        return publicationService.obtenerTodasLasPublicaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicationDTO> obtenerPublicacionPorId(@PathVariable(name = "id") long id){

        return ResponseEntity.ok(publicationService.obtenerPublicacionPorId(id));
    }

    @PostMapping
    public ResponseEntity<PublicationDTO> savePublication(@RequestBody PublicationDTO publicationDTO){

        return new ResponseEntity<>(publicationService.createPublication(publicationDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicationDTO> actualizarPublicationPorId(@RequestBody PublicationDTO publicationDTO,@PathVariable(name = "id") long id){

        PublicationDTO publicacionRespuesta = publicationService.actualizarPublicacion(publicationDTO,id);

        return  new ResponseEntity<>(publicacionRespuesta,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPublicacion(@PathVariable(name ="id") long id){
            publicationService.eliminarPublicacion(id);
        return new ResponseEntity<>("Publicación eliminada con exito",HttpStatus.OK);
    }

}
