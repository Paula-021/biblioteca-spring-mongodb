package br.com.paula.biblioteca.services;

import br.com.paula.biblioteca.entities.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {
    List<Usuario> getAll();

    void cadastrar(Usuario usuario);

    Usuario getById(String id);

    void editar(Usuario usuario);

    void excluir(String id);
}
