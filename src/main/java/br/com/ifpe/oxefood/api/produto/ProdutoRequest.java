package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {
    private Long idCategoria;

    private String codigo;

    private String titulo;

    private String descricao;

    private String valorUnitario;

    private String tempoEntregaMinimo;

    private String tempoEntregaMaximo;

    public Produto build(){
        return Produto.builder()
        .codigo(codigo)
        .titulo(titulo)
        .descricao(descricao)
        .valorUnitario(valorUnitario)
        .tempoEntregaMinimo(tempoEntregaMinimo)
        .tempoEntregaMaximo(tempoEntregaMaximo)
        .build();
    }
}
