package MaiconDouglas.API_Management.Repository;

import MaiconDouglas.API_Management.Entidades.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}