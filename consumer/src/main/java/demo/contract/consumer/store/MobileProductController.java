package demo.contract.consumer.store;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MobileProductController {
  private final RestTemplate restTemplate;

  public MobileProductController(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  @RequestMapping("/mobileProducts/One")
  String findOneMobileProduct() {
    Product product = this.restTemplate.getForObject(
        "http://localhost:8080/products/{id}",
        Product.class,
        1L);
    return "Mobile Product: " + product.getName();
  }
}
