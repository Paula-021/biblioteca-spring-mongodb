package br.com.paula.biblioteca.controllers;

import br.com.paula.biblioteca.entities.Usuario;
import br.com.paula.biblioteca.services.LivroService;
import br.com.paula.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping(value = "/cadastrar-usuario")
    public String carregarPaginaCadastroUsuario(Model model){
        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("usuarios", usuarios);
        return "cadastrar-usuario";
    }
    @PostMapping(value = "/cadastrar-usuario")
    public String cadastrarUsuario(Usuario usuario){
        usuarioService.cadastrar(usuario);
        return "redirect:/cadastrar-usuario";
    }


    @GetMapping(value = "/editar-usuario")
    public String carregarPaginaEditarUsuario(Model model, @RequestParam String id){
        Usuario usuario = usuarioService.getById(id);
        model.addAttribute("usuario", usuario);
        return "editar-usuario";
    }
    @PostMapping(value = "/editar-usuario")
    public String editarUsuario(Usuario usuario){
        usuarioService.editar(usuario);
        return "redirect:/cadastrar-usuario";
    }


    @GetMapping(value = "/excluir-usuario")
    public String carregarCaixaConfirmacaoExcluirUsuario(Model model, @RequestParam String id){
        model.addAttribute("confirmacaoExcluir", "Deseja mesmo excluir o usuario?");
        model.addAttribute("idUsuarioExcluir", id);

        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("usuarios", usuarios);
        return "cadastrar-usuario";
    }
    @PostMapping(value = "/excluir-usuario")
    public String excluirUsuario(String id){
        usuarioService.excluir(id);
        return "redirect:/cadastrar-usuario";
    }







}
