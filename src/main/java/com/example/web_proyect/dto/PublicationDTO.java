package com.example.web_proyect.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublicationDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private String contenido;


}
