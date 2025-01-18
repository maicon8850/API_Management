package MaiconDouglas.API_Management.Repository;
import MaiconDouglas.API_Management.Entidades.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}