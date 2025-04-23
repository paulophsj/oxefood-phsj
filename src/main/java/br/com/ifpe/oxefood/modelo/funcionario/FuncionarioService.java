package br.com.ifpe.oxefood.modelo.funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    @Transactional
    public Funcionario save(Funcionario funcionario){
        funcionario.setHabilitado(Boolean.TRUE);
        return repository.save(funcionario);
    }
}
