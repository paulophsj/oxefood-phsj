package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente) {

        cliente.setHabilitado(Boolean.TRUE);
        return repository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente obterPorId(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public Cliente update(Long id, Cliente clienteAlterado) {

        Cliente cliente = this.obterPorId(id);
        cliente.setNome(clienteAlterado.getNome());
        cliente.setDataNascimento(clienteAlterado.getDataNascimento());
        cliente.setCpf(clienteAlterado.getCpf());
        cliente.setFoneCelular(clienteAlterado.getFoneCelular());
        cliente.setFoneFixo(clienteAlterado.getFoneFixo());

        return repository.save(cliente);
    }

    @Transactional
    public void delete(Long id) {

        Cliente cliente = this.obterPorId(id);
        cliente.setHabilitado(Boolean.FALSE);

        repository.save(cliente);
    }

}
