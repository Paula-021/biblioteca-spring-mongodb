package br.com.paula.biblioteca.controllers;

import br.com.paula.biblioteca.entities.Livro;
import br.com.paula.biblioteca.services.LivroService;
import br.com.paula.biblioteca.services.LivroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LivroController {

    @Autowired // -> injeção de dependencia
    private LivroService livroService; // atributo livroService

    //inversão de controle -> dar poder ao Spring para ele fazer certas coisas

    @GetMapping(value = "/cadastrar-livro") //end-point -> rota
    public String carregarPaginaCadastroLivro(Model model){
        List<Livro> livros = livroService.getAll();
        model.addAttribute("livros", livros);
        return "cadastrar-livro";
    }

    @PostMapping(value = "/cadastrar-livro")
    public String cadastrarLivro(Livro livro){
        //views -> controllers -> models -> daos -> banco de dados (projeto anterior - netbeans)
        //views -> controllers -> services -> repositories -> banco de dados
        livroService.cadastrar(livro);
        return "redirect:/cadastrar-livro";
    }

    //server-side: lado do servidor -> Tomcat e JVM
    // JVM -> Java Virtual Machine
    //client-side: lado do cliente -> navegador
    //thymeleaf -> template engine "engrenagem de template"

    //thymeleaf -> carregar dados do backend no frontend
    // a página é "compilada" os dados do backend carregados para depois ser renderizado pela engrenagem do navegador

    @GetMapping(value = "/editar-livro")
    public String carregarPaginaEditarLivro(Model model, @RequestParam String id){
        Livro livro = livroService.getById(id);
        model.addAttribute("livro", livro);
        return "editar-livro";

    }
    @PostMapping(value = "/editar-livro")
    public String editarLivro(Livro livro, Model model){
        livroService.editar(livro);
        return "redirect:/cadastrar-livro";
    }
    //passo a passo para qualquer funcionalidade (CRUD) (front e back juntos)
    //1°: carregar dados em uma página (get)
    //2°: receber dados para alteração no banco de dados (post)

    //<visibilidade> <tipo de retorno> <nome de método> (<parametros>){
    //public
    //private
    //protected

    @GetMapping(value = "/excluir-livro")
    public String carregarCaixaConfirmacaoExcluirLivro(Model model, @RequestParam String id){
        model.addAttribute("confirmacaoExcluir", "Deseja mesmo excluir o livro?");
        model.addAttribute("idLivroExcluir", id);

        List<Livro> livros = livroService.getAll();
        model.addAttribute("livros", livros);
        return "cadastrar-livro";
    }
    @PostMapping(value = "/excluir-livro")
    public String excluirLivro(String id){
        livroService.excluir(id);
        return "redirect:/cadastrar-livro";
    }

}
