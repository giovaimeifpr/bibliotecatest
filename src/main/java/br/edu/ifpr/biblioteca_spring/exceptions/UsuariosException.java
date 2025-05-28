package br.edu.ifpr.biblioteca_spring.exceptions;

public class UsuariosException extends RuntimeException {
    
    public UsuariosException(){}

    public UsuariosException(String message){
        super(message);
    }

}
