package com.example.padrao.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Orgao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(name = "nome")
    private String nome;

    public Orgao() {
    }

    public Orgao(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Orgao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
