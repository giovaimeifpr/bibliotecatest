
package br.edu.ifpr.biblioteca_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpr.biblioteca_spring.exceptions.UsuariosException;
import br.edu.ifpr.biblioteca_spring.models.Usuario;
import br.edu.ifpr.biblioteca_spring.service.UsuariosService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuariosService usuarioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuarios/lista";
    }

    @GetMapping("/novo")
    public String cadastrar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/form";
    }

    // foi adicionado binding result para verificar se tem erro na parte do cadastro do usuario
    @PostMapping
    public String salvar(@Valid Usuario usuario, BindingResult fields) {
        if (fields.hasErrors()) {
            return "usuarios/form";
        }
        
        usuarioService.adicionar(usuario);
        return "redirect:/usuarios";
    }
    
    @GetMapping("/teste")
    public String erroForcado() {
        throw new UsuariosException("Erro forçado de teste - error.html");
    }

    @GetMapping("/teste500")
    public String erroForcado500() {
        throw new RuntimeException("Erro forçado de teste - 500.");
    }

}
