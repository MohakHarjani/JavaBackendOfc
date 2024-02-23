package vw.mohak.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		
		//For reading about zipkin
		//https://www.appsdeveloperblog.com/micrometer-and-zipkin-in-spring-boot/
		
		
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
