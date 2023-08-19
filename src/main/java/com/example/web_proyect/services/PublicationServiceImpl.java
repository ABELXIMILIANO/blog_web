package com.example.web_proyect.services;

import com.example.web_proyect.dto.PublicationDTO;
import com.example.web_proyect.entities.Publication;
import com.example.web_proyect.exeptions.ResourceNotFoundExeption;
import com.example.web_proyect.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationServiceImpl  implements PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;
    @Override
    public PublicationDTO createPublication(PublicationDTO publicationDTO) {

        Publication publication= new Publication();
        publication.setTitulo(publicationDTO.getTitulo());
        publication.setDescription(publicationDTO.getDescripcion());
        publication.setContenido((publicationDTO.getContenido()));
        Publication nuevaPublication = publicationRepository.save(publication);

        PublicationDTO publicacionRespuesta= mapearDTO(nuevaPublication);

        return publicacionRespuesta;
    }

    @Override
    public List<PublicationDTO> obtenerTodasLasPublicaciones() {
        List<Publication> publicaciones = publicationRepository.findAll();// obtengo todas las publicaciones de mi base de datos atravez del publicationRepository
        return publicaciones.stream().map(publicacion ->mapearDTO(publicacion)).collect(Collectors.toList()); //
    }

    @Override
    public PublicationDTO obtenerPublicacionPorId(Long id) {
        Publication publication = publicationRepository
                .findById(id).orElseThrow(()->new ResourceNotFoundExeption("Publicacion", "id", id));
        return mapearDTO(publication);
    }

    @Override
    public PublicationDTO actualizarPublicacion(PublicationDTO publicationDTO, long id) {
        Publication publication = publicationRepository   //obtengo la publicación que quiero actualizar de mi repositorio
                .findById(id).orElseThrow(()->new ResourceNotFoundExeption("Publicacion", "id", id)); // Es un lambda es cual nos permite poner un metodo dentro  es este caso una exeption
        publication.setTitulo(publicationDTO.getTitulo());
        publication.setDescription(publicationDTO.getDescripcion());
        publication.setContenido((publicationDTO.getContenido()));

        Publication publicacionActualizada = publicationRepository.save(publication);


        return mapearDTO(publicacionActualizada);
    }

    @Override
    public void eliminarPublicacion(long id) {
        Publication publication = publicationRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundExeption("Publicacion", "id", id));

        publicationRepository.delete(publication);
    }


    // Este metodo convierte Entidad a DTO
    private PublicationDTO mapearDTO(Publication publication){
            PublicationDTO publicationDTO = new PublicationDTO();
            publicationDTO.setId(publication.getId());
            publicationDTO.setTitulo(publication.getTitulo());
            publicationDTO.setDescripcion(publication.getDescription());
            publicationDTO.setContenido(publication.getContenido());

        return publicationDTO;
    }



    //Este metodo convierte  de DTO a entidad
    private Publication mapearEntidad(PublicationDTO publicationDTO){
            Publication publicacion = new Publication();
            publicacion.setId(publicationDTO.getId());
            publicacion.setTitulo(publicationDTO.getTitulo());
            publicacion.setDescription(publicationDTO.getDescripcion());
            publicacion.setContenido((publicationDTO.getContenido()));


        return publicacion;
    }




}
