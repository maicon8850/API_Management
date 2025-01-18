package MaiconDouglas.API_Management.Config;

import java.time.Instant;
import java.util.Arrays;

import MaiconDouglas.API_Management.Entidades.*;
import MaiconDouglas.API_Management.Enums.OrderStatus;
import MaiconDouglas.API_Management.Repository.*;

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
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Override
    public void run(String... args) throws Exception {

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


        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        // Salvando os usuários no banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2));

        // Salvando os pedidos no banco de dados
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);
        orderRepository.save(o1);
    }
}
