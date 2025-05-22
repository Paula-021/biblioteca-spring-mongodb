package br.com.paula.biblioteca.repositories;

import br.com.paula.biblioteca.entities.Emprestimo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends MongoRepository<Emprestimo, String> {

}
