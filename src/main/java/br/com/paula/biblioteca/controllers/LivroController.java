package br.com.paula.biblioteca.controllers;

import br.com.paula.biblioteca.entities.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LivroController {

    //inversão de controle -> dar poder ao Spring para ele fazer certas coisas

    @GetMapping(value = "/cadastrar-livro") //end-point -> rota
    public String carregarPaginaCadastroLivro(){
        return "cadastrar-livro";
    }

    public String cadastrarLivro(Livro livro){

    }

    //server-side: lado do servidor -> Tomcat e JVM
    // JVM -> Java Virtual Machine
    //client-side: lado do cliente -> navegador
    //thymeleaf -> template engine "engrenagem de template"

    //thymeleaf -> carregar dados do backend no frontend
    // a página é "compilada" os dados do backend carregados para depois ser renderizado pela engrenagem do navegador

}
