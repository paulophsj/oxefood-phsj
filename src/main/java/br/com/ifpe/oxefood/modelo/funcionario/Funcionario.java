package br.com.ifpe.oxefood.modelo.funcionario;

import java.time.LocalDate;

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
@Table(name="funcionario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Funcionario extends EntidadeAuditavel {
    @Column
    private String nome;
    
    @Column
    private String cpf;
    
    @Column
    private String rg;

    @Column
    private LocalDate dataNascimento;

    @Column
    private String foneCelular;

    @Column
    private String foneFixo;
    
    @Column
    private Double salario;
    
    @Column
    private String enderecoRua;

    @Column
    private String enderecoNumero;

    @Column
    private String enderecoBairro;

    @Column
    private String enderecoCidade;

    @Column
    private String enderecoCep;

    @Column
    private String enderecoUf;

    @Column
    private String enderecoCompleto;
}
