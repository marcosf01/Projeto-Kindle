package com.kindle.biblioteca.repository;

import com.kindle.biblioteca.model.Livro;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LivroRepository extends MongoRepository<Livro, String>{

    Livro findByCodigo(Integer codigo);
    
}
