package br.com.paula.biblioteca.services;

import br.com.paula.biblioteca.entities.Livro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LivroService {

    void cadastrar(Livro livro); //declarar métodos de serviço porém NÃO implementá-los


    List<Livro> getAll();

    Livro getById(String id);

    void editar(Livro livro);

    void excluir(String id);
}
