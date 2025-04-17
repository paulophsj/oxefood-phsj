package br.com.ifpe.oxefood.api.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.api.empresa.EmpresaRequest;
import br.com.ifpe.oxefood.modelo.empesa.Empresa;
import br.com.ifpe.oxefood.modelo.empesa.EmpresaService;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin
public class UsuarioController {
    @Autowired
    private EmpresaService EmpresaService;

    @PostMapping
    public ResponseEntity<Empresa> save(@RequestBody EmpresaRequest request){
        Empresa empresa = EmpresaService.save(request.build());
        return new ResponseEntity<Empresa>(empresa, HttpStatus.CREATED);
    }
}
