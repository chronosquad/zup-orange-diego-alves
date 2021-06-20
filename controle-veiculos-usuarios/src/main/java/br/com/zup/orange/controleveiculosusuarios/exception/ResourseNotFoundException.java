package br.com.zup.orange.controleveiculosusuarios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends RuntimeException{

    public static final int serialVersionUID = 1;

    public ResourseNotFoundException(String message){
        super(message);
    }

}
