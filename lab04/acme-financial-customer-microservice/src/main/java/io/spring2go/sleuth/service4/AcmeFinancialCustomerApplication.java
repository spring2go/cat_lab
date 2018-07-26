package io.spring2go.sleuth.service4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;

@SpringBootApplication
@RestController
public class AcmeFinancialCustomerApplication {

	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@RequestMapping("/startOfCustomer-Microservice")
	public String service4MethodInController() throws InterruptedException {
		Thread.sleep(2000);
		log.info("Hello from Acme's Customer Microservice");
		return "Hello from Acme's Customer Microservice";
	}

	public static void main(String... args) {
		SpringApplication.run(AcmeFinancialCustomerApplication.class, args);
	}
}

