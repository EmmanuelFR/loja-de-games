package edu.unifaa.lojadegames.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unifaa.lojadegames.model.Produto;
import edu.unifaa.lojadegames.model.exception.ResourceBadRequestException;
import edu.unifaa.lojadegames.model.exception.ResourceNotFoundException;
import edu.unifaa.lojadegames.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto adicionar(Produto produto){
        // Aqui poderia verificar muitas coisas.

        produto.setId(0);

        if(produto.getDataLancamento().getTime() == new Date().getTime()){

            throw new ResourceNotFoundException("Este jogo é uma novidade no catálogo.");

        }else if(produto.getDataLancamento().getTime() > new Date().getTime()){

            throw new ResourceNotFoundException("Este jogo estará disponível no catálogo em breve.");

        }

        return produtoRepository.save(produto);
    }

    public List<Produto> obterTodos(){
        return produtoRepository.findAll();
    }

    public Produto obterPorId(Long id){
        Optional<Produto> optProduto = produtoRepository.findById(id);

        if(optProduto.isEmpty()){
            throw new ResourceNotFoundException("Não existe um produto com o ID " + id);
        }

        return optProduto.get();
    }

    public Produto atualizar(Long id, Produto produto){
        // Aqui poderia verificar muitas coisas.
        // Aqui o ideal é verificar se o produto existe no banco antes de mandar atualizar.
        // Se não existir, ai mando uma exception que vai precisar chegar no cliente com o statusCode 404
        if(!produtoRepository.existsById(id)){

            throw new ResourceNotFoundException("Produto não encontrado para o ID: " + id);

        }else if(produto.getDataLancamento().getTime() == new Date().getTime()){

            throw new ResourceNotFoundException("Este jogo é uma novidade no catálogo.");

        }else if(produto.getDataLancamento().getTime() > new Date().getTime()){

            throw new ResourceNotFoundException("Este jogo estará disponível no catálogo em breve.");

        }
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    public void deletar(long id){

        if(!produtoRepository.existsById(id)){
            throw new ResourceNotFoundException("Produto não encontrado para o ID: " + id);
        }

        produtoRepository.deleteById(id);
    }

}
