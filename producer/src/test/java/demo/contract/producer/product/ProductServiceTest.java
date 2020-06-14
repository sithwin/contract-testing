package demo.contract.producer.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    ProductService productService;

    @BeforeEach
    void setup() {
        this.productService = new ProductService();
    }

    @Test
    void findProductById() {
        Product actual = productService.findProductById(1L);

        assertEquals(actual.id, 1L);
    }
}