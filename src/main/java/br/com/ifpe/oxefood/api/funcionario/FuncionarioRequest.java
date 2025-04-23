package br.com.ifpe.oxefood.api.funcionario;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.funcionario.Funcionario;
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
public class FuncionarioRequest {
    private String nome;
    
    private String cpf;
    
    private String rg;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String foneCelular;

    private String foneFixo;
    
    private Double salario;
    
    private String enderecoRua;

    private String enderecoNumero;

    private String enderecoBairro;

    private String enderecoCidade;

    private String enderecoCep;

    private String enderecoUf;

    private String enderecoCompleto;

    public Funcionario build(){
        return Funcionario.builder()
        .nome(nome)
        .cpf(cpf)
        .rg(rg)
        .dataNascimento(dataNascimento)
        .foneCelular(foneCelular)
        .foneFixo(foneFixo)
        .salario(salario)
        .enderecoRua(enderecoRua)
        .enderecoNumero(enderecoNumero)
        .enderecoBairro(enderecoBairro)
        .enderecoCidade(enderecoCidade)
        .enderecoCep(enderecoCep)
        .enderecoUf(enderecoUf)
        .enderecoCompleto(enderecoCompleto)
        .build();
    }
}
