package br.com.ifpe.oxefood.api.usuario;

import java.util.List;

import br.com.ifpe.oxefood.modelo.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

    private String username;

    private String password;

    private List<String> roles;

    
    public Usuario build(){
        
        return Usuario.builder()
            .username(username)
            .password(password)
            .roles(roles)
            .build();
    }
}
