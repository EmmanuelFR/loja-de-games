package edu.unifaa.lojadegames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.unifaa.lojadegames.model.Cliente;
import edu.unifaa.lojadegames.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("*")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente){
        return clienteService.adicionar(cliente);
    }

    @GetMapping
    public List<Cliente> obterTodos(){
        return clienteService.obterTodos();
    }

    @GetMapping("/{id}")
    public Cliente obterPorId(@PathVariable long id){
        return clienteService.obterPorId(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable long id, @RequestBody Cliente cliente){
        return clienteService.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        clienteService.deletar(id);
    }
}
