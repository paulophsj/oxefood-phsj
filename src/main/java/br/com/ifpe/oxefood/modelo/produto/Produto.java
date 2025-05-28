package br.com.ifpe.oxefood.modelo.produto;

import br.com.ifpe.oxefood.modelo.categoria_produto.CategoriaProduto;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Produto")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto extends EntidadeAuditavel {
    @ManyToOne
    private CategoriaProduto categoria;

    @Column
    private String codigo;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private int valorUnitario;

    @Column
    private String tempoEntregaMinimo;

    @Column
    private String tempoEntregaMaximo;
}
