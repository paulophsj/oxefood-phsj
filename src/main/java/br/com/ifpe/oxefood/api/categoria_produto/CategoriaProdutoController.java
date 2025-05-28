package br.com.ifpe.oxefood.api.categoria_produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.categoria_produto.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.categoria_produto.CategoriaProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/categoria_produto")
@CrossOrigin
public class CategoriaProdutoController {

    @Autowired
    private CategoriaProdutoService service;

    @GetMapping
    public ResponseEntity<List<CategoriaProduto>> findAll() {
        List<CategoriaProduto> categorias = service.findAll(); 
        return new ResponseEntity<List<CategoriaProduto>>(categorias, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProduto> findOne(@PathVariable("id") Long id) {
        CategoriaProduto categoria = service.findOne(id);
        return new ResponseEntity<CategoriaProduto>(categoria, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CategoriaProduto> save(@RequestBody CategoriaProdutoRequest request) {
        CategoriaProduto categoria = service.save(request.build());
        return new ResponseEntity<CategoriaProduto>(categoria, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.remove(id);
        return ResponseEntity.ok().build();
    }
}
