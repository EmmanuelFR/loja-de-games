package edu.unifaa.lojadegames.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private long id;

    @Column(nullable = false)
    private String nomeDoJogo; 

    @Column(nullable = false)
    private Date dataLancamento; 

    @Column(nullable = false)
    private double preco; 

    @Column(nullable = false)
    private String plataforma; 

    @OneToMany(mappedBy = "produto")
    @JsonManagedReference
    private List<Categoria> categoria;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getNomeDoJogo() {
        return nomeDoJogo;
    }

    public void setNomeDoJogo(String nomeDoJogo) {
        this.nomeDoJogo = nomeDoJogo;
    }

}
