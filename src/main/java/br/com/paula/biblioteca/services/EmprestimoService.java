package br.com.paula.biblioteca.services;

import br.com.paula.biblioteca.entities.Emprestimo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmprestimoService {
    List<Emprestimo> getAll();

    void cadastrar(Emprestimo emprestimo);

    Emprestimo getById(String id);

    void editar(Emprestimo emprestimo);

    void excluir(String id);
}
