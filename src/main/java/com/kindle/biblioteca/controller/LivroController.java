package com.kindle.biblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import com.kindle.biblioteca.dto.LivroDto;
import com.kindle.biblioteca.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public List<LivroDto> obterLivros() {
        return service.listarLivros();
    }

    @PostMapping
    public ResponseEntity<LivroDto> inlcuirLivro(@RequestBody @Valid LivroDto livro) {
        return new ResponseEntity<>(service.adicionarLivro(livro), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public LivroDto buscarPorId(@PathVariable String id) {
        return service.buscarLivroPorId(id);
    }

    @GetMapping("codigo/{codigo}")
    public LivroDto buscarPorCodigo(@PathVariable Integer codigo) {
        return service.buscarLivroPorCodigo(codigo);
    }

    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable String id) {
        service.excluirLivro(id);
    }

    @PutMapping("/{id}")
    public LivroDto alterarLivro(@PathVariable String id, @RequestBody LivroDto livroAlterar) {
        return service.alterarLivro(id, livroAlterar);
    }
}
