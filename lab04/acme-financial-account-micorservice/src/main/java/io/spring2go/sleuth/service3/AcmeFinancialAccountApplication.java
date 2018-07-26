package io.spring2go.sleuth.service3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;

@SpringBootApplication
@RestController
public class AcmeFinancialAccountApplication {

	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@RequestMapping("/startOfAccount-Microservice")
	public String service3MethodInController() throws InterruptedException {
		Thread.sleep(2000);
		log.info("Hello from Acme Financial's Account Microservice");
		return "Hello from Acme Financial's Account Microservice";
	}

	public static void main(String... args) {
		SpringApplication.run(AcmeFinancialAccountApplication.class, args);
	}
}
