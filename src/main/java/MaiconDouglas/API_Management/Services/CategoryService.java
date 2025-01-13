package MaiconDouglas.API_Management.Services;

import java.util.List;
import java.util.Optional;

import MaiconDouglas.API_Management.Entidades.Category;
import MaiconDouglas.API_Management.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    public List<Category> findAll() {
        return repository.findAll();
    }
    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}