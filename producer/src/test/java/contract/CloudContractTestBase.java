package contract;


import demo.contract.producer.product.Product;
import demo.contract.producer.product.ProductController;
import demo.contract.producer.product.ProductService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public abstract class CloudContractTestBase {
    @Autowired
    ProductController productController;

    @MockBean
    ProductService productService;

    @BeforeEach
    void setup() {
        RestAssuredMockMvc.standaloneSetup(productController);

        Mockito
            .when(productService.findProductById(1L))
            .thenReturn(new Product(1L, "iPhone", "red"));
    }
}
