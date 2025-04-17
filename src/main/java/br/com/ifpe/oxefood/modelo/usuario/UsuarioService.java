package br.com.ifpe.oxefood.modelo.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Transactional
    public Usuario save(Usuario usuario){
        usuario.setHabilitado(Boolean.TRUE);
        return repository.save(usuario);
    }
}
