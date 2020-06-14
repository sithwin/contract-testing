package demo.contract.consumer;

import demo.contract.consumer.store.Product;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(
		stubsMode = StubRunnerProperties.StubsMode.LOCAL,
		ids = "demo.contract:producer:+:stubs:8090")
@SpringBootTest
class ConsumerApplicationTests {
	@Autowired
	private MockMvc mockMvc;

//	@Test
//	public void get_product_from_service_contract() throws Exception {
//		mockMvc
//				.perform(get("/products/1"))
//				.andDo(print())
//				.andExpect(status().isOk())
//				.andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON));
//	}

	// Using BDDAssertions
	@Test
	public void testProductService() {
		// given
		RestTemplate restTemplate = new RestTemplate();

		// when
		ResponseEntity<Product> productResponseEntity =
				restTemplate.getForEntity("http://localhost:8090/products/1", Product.class);

		// then
		BDDAssertions.then(productResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		BDDAssertions.then(productResponseEntity.getBody().getId()).isEqualTo(1L);
		BDDAssertions.then(productResponseEntity.getBody().getName()).isEqualTo("foo");
	}



}
