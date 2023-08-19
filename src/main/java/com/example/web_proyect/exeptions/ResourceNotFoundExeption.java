package com.example.web_proyect.exeptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND) //cuando se haga llamado a esta exepcion se va a responder a un NOT_FOUND
public class ResourceNotFoundExeption extends RuntimeException {
    private static final long serialVersionUID = 1l;

    private String nombreDelRecurso;
    private String nombreDelCampo;
    private Long valorDelCampo;



    public ResourceNotFoundExeption(String nombnreDelRecurso, String nombreDelCampo, long valorDelCampo) {
        super(String.format("%s no encontrada con : %s : '%s'",nombnreDelRecurso,nombreDelCampo,valorDelCampo)); // Estoy
        this.nombreDelRecurso = nombnreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }
}
