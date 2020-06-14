package demo.contract.producer.product;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    private final Map<Long, Product> mapProduct;

    public ProductService() {
        mapProduct = new HashMap<>();
        mapProduct.put(1L, new Product(1L, "iPhone X", "Red Color"));
        mapProduct.put(2L, new Product(2L, "iPhone Xs", "White Color"));
        mapProduct.put(3L, new Product(3L, "iPhone XR", "Black Color"));
    }

    public Product findProductById(Long id) {
        return this.mapProduct.get(id);
    }
}
