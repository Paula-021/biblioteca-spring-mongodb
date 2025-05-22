package br.com.paula.biblioteca.controllers;


import br.com.paula.biblioteca.controllers.dtos.EmprestimoDTO;
import br.com.paula.biblioteca.entities.Emprestimo;
import br.com.paula.biblioteca.entities.Livro;
import br.com.paula.biblioteca.entities.Usuario;
import br.com.paula.biblioteca.services.EmprestimoService;
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
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;
    @Autowired
    private LivroService livroService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/cadastrar-emprestimo")
    public String carregarPaginaCadastrarEmprestimo(Model model){
        //lista dos emprestimos
        List<Emprestimo> emprestimos = emprestimoService.getAll();
        model.addAttribute("emprestimos", emprestimos);

        //lista dos livros
        List<Livro> livros = livroService.getAll();
        model.addAttribute("livros", livros);

        //lista dos usuários
        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("usuarios", usuarios);
        return "cadastrar-emprestimo";
    }
    @PostMapping(value = "/cadastrar-emprestimo")
    public String cadastrarEmprestimo(EmprestimoDTO emprestimoDTO){
        emprestimoService.cadastrar(emprestimoDTO.paraEntidade());
        return "redirect:/cadastrar-emprestimo";
    }


    @GetMapping(value = "/editar-emprestimo")
    public String carregarPaginaEditarEmprestimo(Model model, @RequestParam String id){
        Emprestimo emprestimo = emprestimoService.getById(id);

       model.addAttribute("emprestimo", emprestimo);
        //lista dos livros
        List<Livro> livros = livroService.getAll();
        livros.removeIf(livro -> livro.getId().equals(emprestimo.getLivro().getId()));
        model.addAttribute("livros", livros);
        //lista dos usuários
        List<Usuario> usuarios = usuarioService.getAll();
        usuarios.removeIf(usuario -> usuario.getId().equals(emprestimo.getUsuario().getId()));
        model.addAttribute("usuarios", usuarios);

        return "editar-emprestimo";
    }
    @PostMapping(value = "/editar-emprestimo")
    public String editarEmprestimo(EmprestimoDTO emprestimoDTO){
        emprestimoService.editar(emprestimoDTO.paraEntidade());
        return "redirect:/cadastrar-emprestimo";
    }

    @GetMapping(value = "/excluir-emprestimo")
    public String carregarPaginaConfirmacaoExcluirEmprestimo(Model model, @RequestParam String id){
        model.addAttribute("confirmacaoExcluir", "Deseja mesmo excluir o emprestimo?");
        model.addAttribute("idEmprestimo", id);

        List<Emprestimo> emprestimos = emprestimoService.getAll();
        model.addAttribute("emprestimos", emprestimos);
        return "cadastrar-emprestimo";
    }

    @PostMapping(value = "/excluir-emprestimo")
    public String excluirEmpestimo(String id){
        emprestimoService.excluir(id);
        return "redirect:/cadastrar-emprestimo";
    }


}
