package MaiconDouglas.API_Management.Recursos;

import java.util.List;

import MaiconDouglas.API_Management.Entidades.Order; // Importação correta
import MaiconDouglas.API_Management.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = service.findAll(); // Busca todos os pedidos no serviço
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = service.findById(id); // Busca pedido pelo ID no serviço
        return ResponseEntity.ok().body(obj);
    }
}
