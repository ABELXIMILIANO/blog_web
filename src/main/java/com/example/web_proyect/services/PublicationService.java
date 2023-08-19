package com.example.web_proyect.services;

import com.example.web_proyect.dto.PublicationDTO;

import java.util.List;

public interface PublicationService {

    public PublicationDTO createPublication(PublicationDTO publicationDTO);
    public List<PublicationDTO> obtenerTodasLasPublicaciones();

    public PublicationDTO obtenerPublicacionPorId(Long id);
    public  PublicationDTO actualizarPublicacion(PublicationDTO publicationDTO, long id);
    public void eliminarPublicacion(long id);
}
