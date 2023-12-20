package edu.unifaa.lojadegames.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private long id;

    private String generoDoJogo; 

    @ManyToOne
    @JoinColumn(name = "id_produto")
    @JsonBackReference
    private Produto produto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGeneroDoJogo() {
        return generoDoJogo;
    }

    public void setGeneroDoJogo(String generoDoJogo) {
        this.generoDoJogo = generoDoJogo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
}
