package MaiconDouglas.API_Management.Config;

import java.time.Instant;
import java.util.Arrays;

import MaiconDouglas.API_Management.Entidades.Order;
import MaiconDouglas.API_Management.Entidades.User;
import MaiconDouglas.API_Management.Repository.OrderRepository;
import MaiconDouglas.API_Management.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration // Indica que esta classe configura o sistema
@Profile("test") // Será executada apenas no perfil de "teste"
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        // Instância de usuários
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        // Instância de pedidos associados aos usuários
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        // Salvando os usuários no banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2));

        // Salvando os pedidos no banco de dados
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
