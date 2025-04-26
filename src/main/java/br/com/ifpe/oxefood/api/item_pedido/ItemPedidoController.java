package br.com.ifpe.oxefood.api.item_pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.item_pedido.ItemPedidoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.ifpe.oxefood.modelo.item_pedido.ItemPedido;


@RestController
@RequestMapping("/api/item-pedido")
@CrossOrigin
public class ItemPedidoController {
    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping
    public ResponseEntity<ItemPedido> save(@RequestBody ItemPedidoRequest request) {
        ItemPedido itemPedido = itemPedidoService.save(request.build());
        return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.CREATED);
    }
}
