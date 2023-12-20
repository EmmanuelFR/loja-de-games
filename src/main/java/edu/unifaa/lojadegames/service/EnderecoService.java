package edu.unifaa.lojadegames.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.unifaa.lojadegames.model.Endereco;
import edu.unifaa.lojadegames.model.exception.ResourceNotFoundException;
import edu.unifaa.lojadegames.repository.EnderecoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    // Método para adicionar um endereco
    public Endereco adicionar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    // Método para obter todos os enderecos
    public List<Endereco> obterTodos(){
        return enderecoRepository.findAll();
    }

    // Método para obter um endereco pelo ID
    public Endereco obterPorId(Long id){
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if(endereco.isPresent()){
            return endereco.get();
        }
        // Trate o caso onde o endereco não é encontrado
        // Pode ser com uma exceção ou retornando null
        throw new ResourceNotFoundException("Endereço não encontrado para o ID: " + id);
    }

    // Método para atualizar um endereco
    public Endereco atualizar(Long id, Endereco enderecoAtualizado){
        if(!enderecoRepository.existsById(id)){
            throw new ResourceNotFoundException("Endereço não encontrado para o ID: " + id);
        }
        enderecoAtualizado.setId(id);
        return enderecoRepository.save(enderecoAtualizado);
    }

    // Método para deletar um endereco
    public void deletar(Long id){
        if(!enderecoRepository.existsById(id)){
            throw new ResourceNotFoundException("Endereço não encontrado para o ID: " + id);
        }
        enderecoRepository.deleteById(id);
    }
}
