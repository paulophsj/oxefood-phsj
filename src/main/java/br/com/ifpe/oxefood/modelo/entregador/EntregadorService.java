package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

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
        entregador.setAtivo(Boolean.TRUE);
        return entregadorRepository.save(entregador);
    }
    public List<Entregador> findAll(){
        return entregadorRepository.findAll();
    }
    public Entregador findById(Long id){
        return entregadorRepository.findById(id).get();
    }
    @Transactional
    public Entregador update(Long id, Entregador entregadorAlterado){
        Entregador entregador = this.findById(id);
        entregador.setNome(entregadorAlterado.getNome());
        entregador.setCpf(entregadorAlterado.getCpf());
        entregador.setRg(entregadorAlterado.getRg());
        entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
        entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
        entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
        entregador.setQtdEntregasRealizadas(entregadorAlterado.getQtdEntregasRealizadas());
        entregador.setValorFrete(entregadorAlterado.getValorFrete());
        entregador.setEnderecoRua(entregadorAlterado.getEnderecoRua());
        entregador.setEnderecoCompleto(entregadorAlterado.getEnderecoCompleto());
        entregador.setEnderecoNumero(entregadorAlterado.getEnderecoNumero());
        entregador.setEnderecoBairro(entregadorAlterado.getEnderecoBairro());
        entregador.setEnderecoCidade(entregadorAlterado.getEnderecoCidade());
        entregador.setEnderecoCep(entregadorAlterado.getEnderecoCep());
        entregador.setEnderecoUf(entregadorAlterado.getEnderecoUf());
        entregador.setAtivo(entregadorAlterado.getAtivo());
        
        return entregadorRepository.save(entregador);
    }
    @Transactional
    public void delete(Long id){
        Entregador entregador = this.findById(id);
        entregador.setHabilitado(Boolean.FALSE);
        entregadorRepository.save(entregador);
    }
}
