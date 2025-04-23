package br.com.ifpe.oxefood.api.endereco_cliente;

import br.com.ifpe.oxefood.modelo.endereco_cliente.enderecoCliente;
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
public class enderecoClienteRequest {
    private String rua;

    private String numero;

    private String bairro;

    private String cep;

    private String cidade;

    private String estado;

    private String complemento;

    public enderecoCliente build(){
        return enderecoCliente.builder()
        .rua(rua)
        .numero(numero)
        .bairro(bairro)
        .cep(cep)
        .cidade(cidade)
        .estado(estado)
        .complemento(complemento)
        .build();
    }
}
