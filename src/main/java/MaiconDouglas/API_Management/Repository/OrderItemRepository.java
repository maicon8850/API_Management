package MaiconDouglas.API_Management.Repository;

import MaiconDouglas.API_Management.Entidades.OrderItem;
import MaiconDouglas.API_Management.Pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}