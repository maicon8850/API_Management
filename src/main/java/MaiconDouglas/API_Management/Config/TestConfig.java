package MaiconDouglas.API_Management.Config;

import java.time.Instant;
import java.util.Arrays;

import MaiconDouglas.API_Management.Entidades.Category;
import MaiconDouglas.API_Management.Entidades.Order;
import MaiconDouglas.API_Management.Entidades.Product;
import MaiconDouglas.API_Management.Entidades.User;
import MaiconDouglas.API_Management.Enums.OrderStatus;
import MaiconDouglas.API_Management.Repository.CategoryRepository;
import MaiconDouglas.API_Management.Repository.OrderRepository;
import MaiconDouglas.API_Management.Repository.ProductRepository;
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
    private CategoryRepository categoryRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {

        // Instância de usuários
        User u1 = new User(null, "Maria", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(null, "Maicon", "maicon.douglas3527@gmail.com", "999999999", "123456");

        // Instância de pedidos associados aos usuários
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);


        Category cat1 = new Category(null, "Eletrônicos");
        Category cat2 = new Category(null, "Celulares");
        Category cat3 = new Category(null, "Computadores");


        Product p1 = new Product(null, "Cadeira Gamer", "Ergonomia e conforto para longas horas de uso.", 799.99, "");
        Product p2 = new Product(null, "Fone de Ouvido Bluetooth", "Som de alta qualidade com conexão sem fio.", 199.90, "");
        Product p3 = new Product(null, "Notebook Lenovo Ideapad", "Ideal para estudos e trabalho com desempenho confiável.", 2999.00, "");
        Product p4 = new Product(null, "Smartphone Galaxy S22", "Tecnologia de ponta com câmeras avançadas.", 4599.00, "");
        Product p5 = new Product(null, "Livro Java para Iniciantes", "Tudo o que você precisa saber para começar a programar em Java.", 89.90, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // Salvando os usuários no banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2,u3));

        // Salvando os pedidos no banco de dados
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }
}
