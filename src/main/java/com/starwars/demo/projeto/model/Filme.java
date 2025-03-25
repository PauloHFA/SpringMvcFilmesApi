package com.starwars.demo.projeto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "filmes")  // Caso queira especificar o nome da tabela
public class Filme {
    @GeneratedValue
    @Id
    private int id;

    private String nome;
    private String genero;
    private float avaliacao;
    private int duracao;
    private String sinopse;
}
