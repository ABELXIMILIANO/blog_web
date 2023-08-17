package com.example.web_proyect.services;

import com.example.web_proyect.dto.PublicationDTO;
import com.example.web_proyect.entities.Publication;
import com.example.web_proyect.repositories.PublicationRepository;

public class PublicationServiceImpl  implements PuplicationService{

    private PublicationRepository publicationRepository;
    @Override
    public PublicationDTO createPublication(PublicationDTO publicationDTO) {
        //convertimos de DTO a entidad

        Publication publication = new Publication();
        publication.setTitulo(publicationDTO.getTitulo());
        publication.setDescription(publicationDTO.getDescripcion());
        publication.setContenido(publicationDTO.getContenido());

        Publication nuevaPublication = publicationRepository.save(publication);

        //convertimos de entidad a DTO para que sea el dto el que interactue con nuestro controlador y no  nuestro modelo

        PublicationDTO publicacionRespuesta= new PublicationDTO();
        publicacionRespuesta.setId(nuevaPublication.getId());
        publicacionRespuesta.setTitulo(nuevaPublication.getTitulo());
        publicacionRespuesta.setDescripcion(nuevaPublication.getDescription());
        publicacionRespuesta.setContenido(nuevaPublication.getContenido());

        return publicacionRespuesta;
    }
}
