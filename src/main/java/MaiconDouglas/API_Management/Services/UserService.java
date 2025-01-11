package MaiconDouglas.API_Management.Services;

import java.util.List;
import java.util.Optional;

import MaiconDouglas.API_Management.Entidades.User;
import MaiconDouglas.API_Management.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository; //ONDE VAI ACESSAR O BANCO DE DADOS
    public List<User> findAll() {
        return repository.findAll();
    }
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get(); // Retorna o usuário encontrado ou lança exceção
    }
}