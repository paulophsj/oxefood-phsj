package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.exception.ProdutoException;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto) {
        if (produto.getValorUnitario() < 10) {
            throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO_PRODUTO);
        }

        produto.setHabilitado(Boolean.TRUE);
        return repository.save(produto);
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto obterPorId(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public Produto update(Long id, Produto novoProduto) {
        Produto produto = this.obterPorId(id);

        produto.setCategoria(novoProduto.getCategoria());
        produto.setCodigo(novoProduto.getCodigo());
        produto.setTitulo(novoProduto.getTitulo());
        produto.setDescricao(novoProduto.getDescricao());
        produto.setValorUnitario(novoProduto.getValorUnitario());
        produto.setTempoEntregaMaximo(novoProduto.getTempoEntregaMaximo());
        produto.setTempoEntregaMinimo(novoProduto.getTempoEntregaMinimo());

        return repository.save(produto);
    }

    @Transactional
    public void delete(Long id) {
        Produto produto = this.obterPorId(id);
        produto.setHabilitado(false);
        repository.save(produto);
    }

    public List<Produto> filtrar(String codigo, String titulo, Long idCategoria) {

        List<Produto> listaProdutos = repository.findAll();

        if ((codigo != null && !"".equals(codigo)) &&
                (titulo == null || "".equals(titulo)) &&
                (idCategoria == null)) {
            listaProdutos = repository.consultarPorCodigo(codigo);
        } else if ((codigo == null || "".equals(codigo)) &&
                (titulo != null && !"".equals(titulo)) &&
                (idCategoria == null)) {
            listaProdutos = repository.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo);
        } else if ((codigo == null || "".equals(codigo)) &&
                (titulo == null || "".equals(titulo)) &&
                (idCategoria != null)) {
            listaProdutos = repository.consultarPorCategoria(idCategoria);
        } else if ((codigo == null || "".equals(codigo)) &&
                (titulo != null && !"".equals(titulo)) &&
                (idCategoria != null)) {
            listaProdutos = repository.consultarPorTituloECategoria(titulo, idCategoria);
        }

        return listaProdutos;
    }

}
