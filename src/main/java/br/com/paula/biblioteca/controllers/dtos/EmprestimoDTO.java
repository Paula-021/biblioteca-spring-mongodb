package br.com.paula.biblioteca.controllers.dtos;

import br.com.paula.biblioteca.entities.Emprestimo;
import br.com.paula.biblioteca.entities.Livro;
import br.com.paula.biblioteca.entities.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmprestimoDTO { //DTO -> Data Transfer Object -> Objeto de Transferencia de Dados
    // View -> DTO -> Controller

    private String idEmprestimo;
    private String idLivro;
    private String idUsuario;
    private String dataInicio;
    private String dataFim;

    private static final DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Emprestimo paraEntidade(){
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId(idEmprestimo);

        Livro livro = new Livro();
        livro.setId(idLivro);
        emprestimo.setLivro(livro);

        Usuario usuario = new Usuario();
        usuario.setId(idUsuario);
        emprestimo.setUsuario(usuario);

        emprestimo.setDataInicio(LocalDate.parse(dataInicio, formatador));
        emprestimo.setDataFim(LocalDate.parse(dataFim, formatador));
        return emprestimo;
    }

    public String getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(String idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public String getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(String idLivro) {
        this.idLivro = idLivro;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
}
