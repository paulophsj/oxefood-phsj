package br.com.ifpe.oxefood.modelo.item_pedido;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="item_pedido")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido extends EntidadeAuditavel{
    @Column
    private int quantidade;

    @Column
    private double valorUnitarioItem;

    @Column
    private double valorTotalItem;

    @Column
    private String observacaoItem;
}
