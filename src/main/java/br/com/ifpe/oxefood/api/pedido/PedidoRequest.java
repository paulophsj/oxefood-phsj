package br.com.ifpe.oxefood.api.pedido;

import java.time.LocalDateTime;

import br.com.ifpe.oxefood.modelo.pedido.Pedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequest {
    private LocalDateTime dataHora;

    private Double valorTotal;

    private Double taxaEntrega;

    private String observacaoGeral;

    private boolean retiradaEmLoja;

    private String enderecoEntregaRua;

    private String enderecoEntregaNumero;

    private String enderecoEntregaBairro;

    private String enderecoEntregaCidade;

    private String enderecoEntregaCep;

    private String enderecoEntregaEstado;

    private String enderecoEntregaComplemento;

    public Pedido build() {
        return Pedido.builder()
                .dataHora(dataHora)
                .valorTotal(valorTotal)
                .taxaEntrega(taxaEntrega)
                .observacaoGeral(observacaoGeral)
                .retiradaEmLoja(retiradaEmLoja)
                .enderecoEntregaRua(enderecoEntregaRua)
                .enderecoEntregaNumero(enderecoEntregaNumero)
                .enderecoEntregaBairro(enderecoEntregaBairro)
                .enderecoEntregaCidade(enderecoEntregaCidade)
                .enderecoEntregaCep(enderecoEntregaCep)
                .enderecoEntregaEstado(enderecoEntregaEstado)
                .enderecoEntregaComplemento(enderecoEntregaComplemento)
                .build();
}
}