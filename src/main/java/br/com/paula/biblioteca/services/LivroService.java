package br.com.paula.biblioteca.services;

import br.com.paula.biblioteca.entities.Livro;
import org.springframework.stereotype.Service;

@Service
public interface LivroService { //declarar métodos de serviço porém NÃO implementá-los

    public void cadastrarLivro(Livro livro);
}
