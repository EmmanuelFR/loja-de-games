package edu.unifaa.lojadegames.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unifaa.lojadegames.model.Categoria;
import edu.unifaa.lojadegames.model.exception.ResourceBadRequestException;
import edu.unifaa.lojadegames.model.exception.ResourceNotFoundException;
import edu.unifaa.lojadegames.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria adicionar(Categoria categoria){
        // Aqui poderia verificar muitas coisas.

        categoria.setId(0);
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obterTodos(){
        return categoriaRepository.findAll();
    }

    public Categoria obterPorId(Long id){
        Optional<Categoria> optCategoria = categoriaRepository.findById(id);

        if(optCategoria.isEmpty()){
            throw new ResourceNotFoundException("Não existe um categoria com o ID " + id);
        }

        return optCategoria.get();
    }

    public Categoria atualizar(Long id, Categoria categoria){
        // Aqui poderia verificar muitas coisas.
        // Aqui o ideal é verificar se o categoria existe no banco antes de mandar atualizar.
        // Se não existir, ai mando uma exception que vai precisar chegar no cliente com o statusCode 404
        if(!categoriaRepository.existsById(id)){

            throw new ResourceNotFoundException("Categoria não encontrada para o ID: " + id);
        }

        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    public void deletar(long id){

        if(!categoriaRepository.existsById(id)){
            throw new ResourceNotFoundException("Categoria não encontrada para o ID: " + id);
        }

        categoriaRepository.deleteById(id);
    }

}
