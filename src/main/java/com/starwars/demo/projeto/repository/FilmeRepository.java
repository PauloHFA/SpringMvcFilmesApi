package com.starwars.demo.projeto.repository;

import com.starwars.demo.projeto.model.Filme;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FilmeRepository extends CrudRepository<Filme, Integer> {
    Optional<Filme> findByNome(String nome);

}
