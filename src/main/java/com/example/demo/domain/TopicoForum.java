package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "topicos_forum")
public class TopicoForum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String conteudo;
    private LocalDateTime dataCriacao;
    private Integer quantidadeRespostas;

    // Construtor padrão
    public TopicoForum() {
        this.dataCriacao = LocalDateTime.now();
        this.quantidadeRespostas = 0;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getQuantidadeRespostas() {
        return quantidadeRespostas;
    }

    public void setQuantidadeRespostas(Integer quantidadeRespostas) {
        this.quantidadeRespostas = quantidadeRespostas;
    }
}