package demo.contract.producer.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {
    ProductController productController;
    ProductService productService;

    @BeforeEach
    void setup() {
        productService = new ProductService();
        this.productController = new ProductController(productService);
    }

    @Test
    void findProductById() {
        Product product = productController.findProductById(1L);

        assertEquals(1L, product.id);
    }
}