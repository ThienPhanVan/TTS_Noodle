package com.cg.service.product;

import com.cg.model.Product;
import com.cg.service.IGeneralService;

<<<<<<< HEAD
public interface ProductService extends IGeneralService<Product> {
=======
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void softDelete(Product product) {

    }
>>>>>>> development
}
