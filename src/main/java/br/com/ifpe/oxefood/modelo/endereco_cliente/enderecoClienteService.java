package br.com.ifpe.oxefood.modelo.endereco_cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class enderecoClienteService {
    @Autowired
    private enderecoClienteRepository repository;

    @Transactional
    public enderecoCliente save(enderecoCliente endereco){
        endereco.setHabilitado(Boolean.TRUE);
        return repository.save(endereco);
    }
}
