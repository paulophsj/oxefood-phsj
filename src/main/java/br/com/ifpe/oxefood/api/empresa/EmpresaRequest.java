package br.com.ifpe.oxefood.api.empresa;

import br.com.ifpe.oxefood.modelo.empesa.Empresa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaRequest {
    private String site;
    private String cpnj;
    private String inscricaoEstadual;
    private String nomeEmpresarial;
    private String nomeFantasia;
    private String fone;
    private String foneAlternativo;

    public Empresa build(){
        return Empresa.builder()
        .site(site)
        .cnpj(cpnj)
        .inscricaoEstadual(inscricaoEstadual)
        .nomeEmpresarial(nomeEmpresarial)
        .nomeFantasia(nomeFantasia)
        .fone(fone)
        .foneAlternativo(foneAlternativo)
        .build();
    }
}
