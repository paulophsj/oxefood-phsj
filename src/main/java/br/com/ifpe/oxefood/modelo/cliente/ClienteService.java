package br.com.ifpe.oxefood.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import jakarta.transaction.Transactional;
import main.java.br.com.ifpe.oxefood.modelo.acesso.PerfilRepository;
import main.java.br.com.ifpe.oxefood.modelo.acesso.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.endereco_cliente.enderecoCliente;
import br.com.ifpe.oxefood.modelo.endereco_cliente.enderecoClienteRepository;
import br.com.ifpe.oxefood.util.exception.ClienteException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    enderecoClienteRepository enderecoClienteRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PerfilRepository perfilUsuarioRepository;

    @Transactional
    public Cliente save(Cliente cliente) {
        String foneSeparado[] = cliente.getFoneCelular().split(" ");

        if (!foneSeparado[0].equals("(81)")) {
            throw new ClienteException(ClienteException.DEVE_TER_DDD_81);
        }
        usuarioService.save(cliente.getUsuario());

        for (Perfil perfil : cliente.getUsuario().getRoles()) {
            perfil.setHabilitado(Boolean.TRUE);
            perfilUsuarioRepository.save(perfil);
        }

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

    @Transactional
    public enderecoCliente adicionarEnderecoCliente(Long clienteId, enderecoCliente endereco) {

        Cliente cliente = this.obterPorId(clienteId);

        endereco.setCliente(cliente);
        endereco.setHabilitado(Boolean.TRUE);
        enderecoClienteRepository.save(endereco);
        List<enderecoCliente> listaEnderecoCliente = cliente.getEnderecos();

        if (listaEnderecoCliente == null) {
            listaEnderecoCliente = new ArrayList<enderecoCliente>();
        }

        listaEnderecoCliente.add(endereco);
        cliente.setEnderecos(listaEnderecoCliente);
        repository.save(cliente);

        return endereco;
    }

    @Transactional
    public enderecoCliente atualizarEnderecoCliente(Long id, enderecoCliente enderecoAlterado) {

        enderecoCliente endereco = enderecoClienteRepository.findById(id).get();
        endereco.setRua(enderecoAlterado.getRua());
        endereco.setNumero(enderecoAlterado.getNumero());
        endereco.setBairro(enderecoAlterado.getBairro());
        endereco.setCep(enderecoAlterado.getCep());
        endereco.setCidade(enderecoAlterado.getCidade());
        endereco.setEstado(enderecoAlterado.getEstado());
        endereco.setComplemento(enderecoAlterado.getComplemento());

        return enderecoClienteRepository.save(endereco);
    }

    @Transactional
    public void removerEnderecoCliente(Long idEndereco) {

        enderecoCliente endereco = enderecoClienteRepository.findById(idEndereco).get();
        endereco.setHabilitado(Boolean.FALSE);
        enderecoClienteRepository.save(endereco);

        Cliente cliente = this.obterPorId(endereco.getCliente().getId());
        cliente.getEnderecos().remove(endereco);
        repository.save(cliente);
    }

}
