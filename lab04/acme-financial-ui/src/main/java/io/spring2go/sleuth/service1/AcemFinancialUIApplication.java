package io.spring2go.sleuth.service1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.invoke.MethodHandles;

@SpringBootApplication
@RestController
public class AcemFinancialUIApplication {

	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired RestTemplate restTemplate;
	@Autowired Tracer tracer;
	@Value("${service2.address:localhost:8082}") String serviceAddress;

	@RequestMapping("/start")
	public String start() throws InterruptedException {
		log.info("Welcome To Acme Financial. Calling Acme Financial's Back Office Microservice");
		String response = restTemplate.getForObject("http://" + serviceAddress + "/startOfBackOffice-Service", String.class);
		Thread.sleep(100);
		log.info("Got response from Acme Financial's Back Office Microservice [{}]", response);
		return response;
	}

	@RequestMapping("/readtimeout")
	public String timeout() throws InterruptedException {
		Span span = this.tracer.createSpan("first_span");
		try {
			Thread.sleep(300);
			log.info("Hello from service1. Calling service2 - should end up with read timeout");
			String response = restTemplate.getForObject("http://" + serviceAddress + "/readtimeout", String.class);
			log.info("Got response from service2 [{}]", response);
			return response;
		} finally {
			this.tracer.close(span);
		}
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String... args) {
		SpringApplication.run(AcemFinancialUIApplication.class, args);
	}
}
