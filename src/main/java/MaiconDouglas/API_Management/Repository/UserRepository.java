package MaiconDouglas.API_Management.Repository;

import MaiconDouglas.API_Management.Entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}