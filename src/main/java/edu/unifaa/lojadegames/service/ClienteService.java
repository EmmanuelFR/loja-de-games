package edu.unifaa.lojadegames.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.unifaa.lojadegames.model.Cliente;
import edu.unifaa.lojadegames.model.exception.ResourceNotFoundException;
import edu.unifaa.lojadegames.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    // Método para adicionar um cliente
    public Cliente adicionar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    // Método para obter todos os clientes
    public List<Cliente> obterTodos(){
        return clienteRepository.findAll();
    }

    // Método para obter um cliente pelo ID
    public Cliente obterPorId(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            return cliente.get();
        }
        // Trate o caso onde o cliente não é encontrado
        // Pode ser com uma exceção ou retornando null
        throw new ResourceNotFoundException("Cliente não encontrado para o ID: " + id);
    }

    // Método para atualizar um cliente
    public Cliente atualizar(Long id, Cliente clienteAtualizado){
        if(!clienteRepository.existsById(id)){
            throw new ResourceNotFoundException("Cliente não encontrado para o ID: " + id);
        }
        clienteAtualizado.setId(id);
        return clienteRepository.save(clienteAtualizado);
    }

    // Método para deletar um cliente
    public void deletar(Long id){
        if(!clienteRepository.existsById(id)){
            throw new ResourceNotFoundException("Cliente não encontrado para o ID: " + id);
        }
        clienteRepository.deleteById(id);
    }
}
