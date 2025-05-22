package br.com.ifpe.oxefood.modelo.categoria_produto;

import org.hibernate.annotations.SQLRestriction;

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
@Builder
@Getter
@Setter
@SQLRestriction("habilitado = true")
@Table(name = "categoria_produto")
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProduto extends EntidadeAuditavel {
    @Column
    private String descricao;
}
