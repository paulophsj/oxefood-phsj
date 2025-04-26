package br.com.ifpe.oxefood.api.item_pedido;

import br.com.ifpe.oxefood.modelo.item_pedido.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoRequest {
    private int quantidade;

    private double valorUnitarioItem;

    private double valorTotalItem;

    private String observacaoItem;

    public ItemPedido build(){
        return ItemPedido.builder()
                .quantidade(quantidade)
                .valorUnitarioItem(valorUnitarioItem)
                .valorTotalItem(valorTotalItem)
                .observacaoItem(observacaoItem)
                .build();
    }
}
