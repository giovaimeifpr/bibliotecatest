package br.edu.ifpr.biblioteca_spring.controller.errors;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.ifpr.biblioteca_spring.exceptions.UsuariosException;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
    
    @ExceptionHandler(UsuariosException.class)
    public String validacaoUsuariosException(UsuariosException ex, Model model){


        model.addAttribute("erro", "Um problema ocorreu1");
        model.addAttribute("descricao", ex.getMessage());

        return "error/error";

    }
   
}
