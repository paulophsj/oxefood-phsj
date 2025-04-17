package br.com.ifpe.oxefood.modelo.usuario;

import java.util.List;

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
@Table(name = "Usuario")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends EntidadeAuditavel {
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private List<String> roles;
}
