package br.com.paula.biblioteca.services;

import br.com.paula.biblioteca.entities.Livro;
import br.com.paula.biblioteca.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService { // -> classe serviço usada para tratamento de dados
    //implementação dos métodos da interface LivroService

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public void cadastrar(Livro livro) {

        livroRepository.insert(livro);
    }

    @Override
    public List<Livro> getAll() {
        List<Livro> livros = livroRepository.findAll();
        return livros;
    }

    @Override
    public Livro getById(String id) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if (livroOptional.isPresent()) {
            return livroOptional.get();
        }
        return null;
    }

    @Override
    public void editar(Livro livro) {
        livroRepository.save(livro);
    }

    @Override
    public void excluir(String id) {
        livroRepository.deleteById(id);
    }


}
