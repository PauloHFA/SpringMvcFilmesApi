package com.starwars.demo.projeto.controller;

import com.starwars.demo.projeto.model.Filme;
import com.starwars.demo.projeto.service.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme filme) {
        Filme filmeCadastrado = filmeService.cadastrarFilme(filme);
        return new ResponseEntity<>(filmeCadastrado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilmePorId(@PathVariable int id) {
        filmeService.deletarFilmePorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarFilmePorId(@PathVariable int id) {
        Optional<Filme> filmeOptional = filmeService.buscarFilmePorId(id);
        return filmeOptional.map(filme -> new ResponseEntity<>(filme, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Filme>> listarTodosFilmes() {
        List<Filme> filmes = filmeService.listarTodosFilmes();
        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }

    @PutMapping("/nota")
    public ResponseEntity<Filme> darNota(@RequestParam String nome, @RequestParam int nota) {
        try {
            Filme filmeComNota = filmeService.darNota(nome, nota);
            return new ResponseEntity<>(filmeComNota, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
