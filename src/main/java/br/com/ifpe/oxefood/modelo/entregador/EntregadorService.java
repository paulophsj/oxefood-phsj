package br.com.ifpe.oxefood.modelo.entregador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EntregadorService {
    @Autowired
    private EntregadorRepository entregadorRepository;

    @Transactional
    public Entregador save(Entregador entregador){
        entregador.setHabilitado(Boolean.TRUE);
        return entregadorRepository.save(entregador);
    }
}
