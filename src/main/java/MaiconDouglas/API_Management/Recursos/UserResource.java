package MaiconDouglas.API_Management.Recursos;

import MaiconDouglas.API_Management.Entidades.User;
import MaiconDouglas.API_Management.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    // Endpoint para listar todos os usuários
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll(); // Busca todos os usuários no banco
        return ResponseEntity.ok().body(list);
    }

    // Endpoint para buscar um usuário pelo ID
    @GetMapping(value = "/{id}") //FUNCIONALIDADE QUE BUSCA USUARIO EXPECIFICO
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
