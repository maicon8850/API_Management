package MaiconDouglas.API_Management.Services;

import java.util.List;
import java.util.Optional;

import MaiconDouglas.API_Management.Entidades.Product;
import MaiconDouglas.API_Management.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    public List<Product> findAll() {
        return repository.findAll();
    }
    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}