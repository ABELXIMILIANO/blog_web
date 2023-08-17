package com.example.web_proyect.repositories;

import com.example.web_proyect.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PublicationRepository extends JpaRepository<Publication,Long> {
    
}
