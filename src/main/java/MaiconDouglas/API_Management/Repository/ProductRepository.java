package MaiconDouglas.API_Management.Repository;

import MaiconDouglas.API_Management.Entidades.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Long> { }
