package br.com.paula.biblioteca.services;

import br.com.paula.biblioteca.entities.Emprestimo;
import br.com.paula.biblioteca.entities.Livro;
import br.com.paula.biblioteca.entities.Usuario;
import br.com.paula.biblioteca.repositories.EmprestimoRepository;
import br.com.paula.biblioteca.repositories.LivroRepository;
import br.com.paula.biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Emprestimo> getAll() {
        List<Emprestimo> emprestimos = emprestimoRepository.findAll();

        for (Emprestimo emprestimo : emprestimos) { //iterar sobre a lista de emprestimos
            String idLivro = emprestimo.getLivro().getId(); //pegar o id do livro
            Optional<Livro> livroOptional = livroRepository.findById(idLivro);
            if (livroOptional.isPresent()) {
                Livro livro = livroOptional.get(); //pegar o livro
                emprestimo.setLivro(livro);
            }

            String idUsuario = emprestimo.getUsuario().getId(); //pegar o id do usuario
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
            if (usuarioOptional.isPresent()) {
                Usuario usuario = usuarioOptional.get(); //pegar o usuário
                emprestimo.setUsuario(usuario);
            }
        }

        return emprestimos;
    }

    @Override
    public void cadastrar(Emprestimo emprestimo) {
        emprestimoRepository.insert(emprestimo);
    }

    @Override
    public Emprestimo getById(String id) {
        Optional<Emprestimo> emprestimoOptional = emprestimoRepository.findById(id);
        if (emprestimoOptional.isPresent()) {
            Emprestimo emprestimo = emprestimoOptional.get();
            String idLivro = emprestimo.getLivro().getId();
            Optional<Livro> livroOptional = livroRepository.findById(idLivro);
            if (livroOptional.isPresent()) {
                Livro livro = livroOptional.get();
                emprestimo.setLivro(livro);
            }
            String idUsuario = emprestimo.getUsuario().getId();
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
            if (usuarioOptional.isPresent()) {
                Usuario usuario = usuarioOptional.get();
                emprestimo.setUsuario(usuario);
            }
            return emprestimo;

        }
        return null;
    }

    @Override
    public void editar(Emprestimo emprestimo) {
        emprestimoRepository.save(emprestimo);

    }

    @Override
    public void excluir(String id) {
        emprestimoRepository.deleteById(id);
    }
}
