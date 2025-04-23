package br.com.ifpe.oxefood.modelo.pedido;

import java.time.LocalDateTime;

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
@Table(name="pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido extends EntidadeAuditavel {
    @Column
    private LocalDateTime dataHora;

    @Column
    private Double valorTotal;

    @Column
    private Double taxaEntrega;

    @Column
    private String observacaoGeral;

    @Column
    private boolean retiradaEmLoja;

    @Column
    private String enderecoEntregaRua;

    @Column
    private String enderecoEntregaNumero;

    @Column
    private String enderecoEntregaBairro;

    @Column
    private String enderecoEntregaCidade;

    @Column
    private String enderecoEntregaCep;

    @Column
    private String enderecoEntregaEstado;

    @Column
    private String enderecoEntregaComplemento;
}
