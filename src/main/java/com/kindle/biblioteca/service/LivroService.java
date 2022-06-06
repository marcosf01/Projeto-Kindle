package com.kindle.biblioteca.service;

import java.util.List;

import com.kindle.biblioteca.dto.LivroDto;

public interface LivroService {
    List<LivroDto> listarLivros();
    LivroDto adicionarLivro(LivroDto livro);
    LivroDto buscarLivroPorId(String id);
    LivroDto buscarLivroPorCodigo(Integer codigo);
    void excluirLivro(String id);
    LivroDto alterarLivro(String id, LivroDto livro);
}
