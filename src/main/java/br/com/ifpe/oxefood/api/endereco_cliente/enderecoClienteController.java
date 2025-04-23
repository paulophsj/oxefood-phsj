package br.com.ifpe.oxefood.api.endereco_cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.endereco_cliente.enderecoCliente;
import br.com.ifpe.oxefood.modelo.endereco_cliente.enderecoClienteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/enderecoCliente")
@CrossOrigin
public class enderecoClienteController {
    @Autowired
    private enderecoClienteService enderecoClienteService;

    @PostMapping()
    public ResponseEntity<enderecoCliente> save(@RequestBody enderecoClienteRequest request) {
        enderecoCliente enderecoCliente = enderecoClienteService.save(request.build());
        return new ResponseEntity<enderecoCliente>(enderecoCliente, HttpStatus.CREATED);
    }
    
}
