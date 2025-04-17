package br.com.ifpe.oxefood.modelo.empesa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository repository;

    @Transactional
    public Empresa save(Empresa empresa){
        empresa.setHabilitado(Boolean.TRUE);
        return repository.save(empresa);
    }
}
