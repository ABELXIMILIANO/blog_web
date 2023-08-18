package com.example.web_proyect.exeptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND) //cuando se haga llamado a esta exepcion se va a responder a un NOT_FOUND
public class ResourseNotFoundExeption extends RuntimeException {
    private static final long serialVersionUID = 1l;

    private String nombnreDelRecurso;
    private String nombreDelCampo;
    private String valorDelCampo;


    public ResourseNotFoundExeption(String nombnreDelRecurso, String nombreDelCampo, String valorDelCampo) {
        super(String.format("%s No encontrado con : %s : '%s'",nombnreDelRecurso,nombreDelCampo,valorDelCampo)); // Estoy
        this.nombnreDelRecurso = nombnreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }
}
