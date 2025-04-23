package br.com.ifpe.oxefood.api.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.oxefood.modelo.pedido.Pedido;
import br.com.ifpe.oxefood.modelo.pedido.PedidoService;


@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping()
    public ResponseEntity<Pedido> save(@RequestBody PedidoRequest request) {
        Pedido pedido = pedidoService.save(request.builder());
        return new ResponseEntity<Pedido>(pedido, HttpStatus.CREATED);
    }
    
}
