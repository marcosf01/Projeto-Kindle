package com.kindle.biblioteca.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kindle.biblioteca.dto.LivroDto;
import com.kindle.biblioteca.model.Livro;
import com.kindle.biblioteca.repository.LivroRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroServiceImpl implements LivroService{

    @Autowired
    private LivroRepository repository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<LivroDto> listarLivros() {
        List<Livro> livros = repository.findAll();
        return livros.stream()
                .map(l -> mapper.map(l, LivroDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public LivroDto adicionarLivro(LivroDto livro) {
        Livro salvarLivro = mapper.map(livro, Livro.class);
        repository.save(salvarLivro);
        return mapper.map(salvarLivro, LivroDto.class);
    }

    @Override
    public LivroDto buscarLivroPorId(String id) {
        Optional<Livro> livro = repository.findById(id);

        if (livro.isPresent()) {
            return mapper.map(livro.get(), LivroDto.class);
        }
        return null;
    }

    @Override
    public LivroDto buscarLivroPorCodigo(Integer codigo) {
        Livro livro = repository.findByCodigo(codigo);
        return mapper.map(livro, LivroDto.class);
    }

    @Override
    public void excluirLivro(String id) {
        repository.deleteById(id);
        
    }

    @Override
    public LivroDto alterarLivro(String id, LivroDto livro) {
        Optional<Livro> livroBusca = repository.findById(id);

        if (livroBusca.isPresent()) {
            Livro livroAlterar = mapper.map(livro, Livro.class);
            livroAlterar.setId(id);
            livroAlterar = repository.save(livroAlterar);
            return mapper.map(livroAlterar, LivroDto.class);
        }
        return null;
    }
    
}
