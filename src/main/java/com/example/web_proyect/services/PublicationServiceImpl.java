package com.example.web_proyect.services;

import com.example.web_proyect.dto.PublicationDTO;
import com.example.web_proyect.entities.Publication;
import com.example.web_proyect.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl  implements PublicationService {

    @Autowired
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

    @Override
    public List<PublicationDTO> obtenerTodasLasPublicaciones() {
        List<Publication> publicaciones = publicationRepository.findAll();
        return null;
    }



    //Entidad a DTO
    private PublicationDTO mapearDTO(Publication publication){
            PublicationDTO publicationDTO = new PublicationDTO();
        publicationDTO.setId(publication.getId());
        publicationDTO.setTitulo(publication.getTitulo());
        publicationDTO.setDescripcion(publication.getDescription());
        publicationDTO.setContenido(publication.getContenido());

        return publicationDTO;
    }


}
