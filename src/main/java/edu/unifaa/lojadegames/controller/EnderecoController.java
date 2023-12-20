package edu.unifaa.lojadegames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.unifaa.lojadegames.model.Endereco;
import edu.unifaa.lojadegames.service.EnderecoService;

@RestController
@RequestMapping("/api/enderecos")
@CrossOrigin("*")
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public Endereco adicionar(@RequestBody Endereco endereco){
        return enderecoService.adicionar(endereco);
    }

    @GetMapping
    public List<Endereco> obterTodos(){
        return enderecoService.obterTodos();
    }

    @GetMapping("/{id}")
    public Endereco obterPorId(@PathVariable long id){
        return enderecoService.obterPorId(id);
    }

    @PutMapping("/{id}")
    public Endereco atualizar(@PathVariable long id, @RequestBody Endereco endereco){
        return enderecoService.atualizar(id, endereco);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        enderecoService.deletar(id);
    }
}
