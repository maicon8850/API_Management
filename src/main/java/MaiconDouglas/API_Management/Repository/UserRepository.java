package MaiconDouglas.API_Management.Repository;

import MaiconDouglas.API_Management.Entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Data JPA que fornece métodos prontos para operações no banco de dados. Exemplos de métodos fornecidos:
    //save(User user): Salva ou atualiza um registro no banco de dados.
          //  findById(Long id): Busca um registro pelo ID.
           // findAll(): Retorna todos os registros de uma tabela.
           // deleteById(Long id): Remove um registro pelo ID.
}