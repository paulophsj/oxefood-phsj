package br.com.ifpe.oxefood.modelo.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public Pedido save(Pedido pedido){
        pedido.setHabilitado(Boolean.TRUE);
        return pedidoRepository.save(pedido);
    }
}
