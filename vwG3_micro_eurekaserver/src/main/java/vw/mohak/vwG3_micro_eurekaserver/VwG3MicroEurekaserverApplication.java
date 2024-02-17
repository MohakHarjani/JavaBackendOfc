package vw.mohak.vwG3_micro_eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class VwG3MicroEurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(VwG3MicroEurekaserverApplication.class, args);
		

		
	}

}
