package edu.unifaa.lojadegames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unifaa.lojadegames.model.Produto;
import edu.unifaa.lojadegames.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos") // Rota ou endpoint
@CrossOrigin("*")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> obterTodos(){
        return produtoService.obterTodos();
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable long id ){
        return produtoService.obterPorId(id);
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return produtoService.adicionar(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable long id, @RequestBody Produto produto){
        return produtoService.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        produtoService.deletar(id);
    }
}

