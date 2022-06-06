package com.kindle.biblioteca.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class LivroDto {
    
    private String id;
    
    @Positive
    private Integer codigo;

    @NotBlank(message = "O título do livro deve possuir caracteres não brancos")
    //@NotEmpty(message = "O título deve ser preenchido")
    private String titulo;
    
    @Positive
    private double valor;

    @PositiveOrZero
    private int quantidadeEstoque;

    @Positive
    private double precoCusto;

    @Size(min = 5, message = "O fornecedor deve possuir no mínimo 5 caracteres")
    private String fornecedor;
    
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    public double getPrecoCusto() {
        return precoCusto;
    }
    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }
    public String getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
}
