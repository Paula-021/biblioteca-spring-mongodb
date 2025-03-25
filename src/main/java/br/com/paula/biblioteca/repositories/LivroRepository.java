package br.com.paula.biblioteca.repositories;

import br.com.paula.biblioteca.entities.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends MongoRepository<Livro, String> {

}
