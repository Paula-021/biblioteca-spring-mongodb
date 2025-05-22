package br.com.paula.biblioteca.services;

import br.com.paula.biblioteca.entities.Usuario;
import br.com.paula.biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    @Override
    public void cadastrar(Usuario usuario) {
        usuarioRepository.insert(usuario);
    }

    @Override
    public Usuario getById(String id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        }
        return null;
    }

    @Override
    public void editar(Usuario usuario) {
        usuarioRepository.save(usuario);

    }

    @Override
    public void excluir(String id) {
        usuarioRepository.deleteById(id);
    }
}
