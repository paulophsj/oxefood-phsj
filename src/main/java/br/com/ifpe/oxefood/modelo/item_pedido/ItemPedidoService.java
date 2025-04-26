package br.com.ifpe.oxefood.modelo.item_pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ItemPedidoService {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Transactional
    public ItemPedido save(ItemPedido itemPedido) {
        itemPedido.setHabilitado(Boolean.TRUE);
        return itemPedidoRepository.save(itemPedido);
    }
}
