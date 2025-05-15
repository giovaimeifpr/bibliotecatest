package br.edu.ifpr.biblioteca_spring.models;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Usuario {

    private Long id;

    // esses @dois arrobas garantem o retorno do erro la no form.html
    @NotBlank(message = "O nome não pode estar vazio")
    @Size(min = 1, max = 25, message = "O nome deve possuir no máximo 25 caracteres")
    private String nome;

    private String cpf;
    private boolean bloqueado;
    private LocalDate dataDeDesbloqueio;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.bloqueado = false;
        this.dataDeDesbloqueio = null;
    }

    public boolean isBloqueado() {
        if (dataDeDesbloqueio != null && LocalDate.now().isAfter(dataDeDesbloqueio)) {
            bloqueado = false;
            dataDeDesbloqueio = null;
        }
        return bloqueado;
    }

    public void bloquearAte(LocalDate data) {
        this.bloqueado = true;
        this.dataDeDesbloqueio = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public LocalDate getDataDeDesbloqueio() {
        return dataDeDesbloqueio;
    }

    public void setDataDeDesbloqueio(LocalDate dataDeDesbloqueio) {
        this.dataDeDesbloqueio = dataDeDesbloqueio;
    }

    // Getters e Setters
    
}
