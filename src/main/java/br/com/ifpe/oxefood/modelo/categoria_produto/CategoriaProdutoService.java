package br.com.ifpe.oxefood.modelo.categoria_produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CategoriaProdutoService {
    @Autowired
    private CategoriaProdutoRepository repository;

    @Transactional
    public CategoriaProduto save(CategoriaProduto categoriaProduto){
        categoriaProduto.setHabilitado(Boolean.TRUE);
        return repository.save(categoriaProduto);
    }
    public List<CategoriaProduto> findAll(){
        return repository.findAll();
    }
    public CategoriaProduto findOne(Long id){
        return repository.findById(id).get();
    }
    @Transactional
    public void remove(Long id){
        CategoriaProduto categoriaProduto = this.findOne(id);
        categoriaProduto.setHabilitado(Boolean.FALSE);
        repository.save(categoriaProduto);
    }
}
