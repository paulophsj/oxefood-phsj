package br.com.ifpe.oxefood.api.funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.ifpe.oxefood.modelo.funcionario.Funcionario;
import br.com.ifpe.oxefood.modelo.funcionario.FuncionarioService;


@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping()
    public ResponseEntity<Funcionario> save(@RequestBody FuncionarioRequest request) {
        Funcionario funcionario = funcionarioService.save(request.build());
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.CREATED);
    }
    
}
