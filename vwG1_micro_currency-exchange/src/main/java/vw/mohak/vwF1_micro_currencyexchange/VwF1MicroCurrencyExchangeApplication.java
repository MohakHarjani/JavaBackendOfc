package vw.mohak.vwF1_micro_currencyexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VwF1MicroCurrencyExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(VwF1MicroCurrencyExchangeApplication.class, args);
		
		
		//=========================================================================================
		//Note.....see the "folder" name for checking grounf F, G.......
		
		//Now we know how one microservice call other using "restTemplate + hardcoded url"
		
		//Now we don't want to hardcode the other service's url
		//we want some central naming server to handle all the instances of our services
		//then our only work would be ==>
		    //one micro makes a call to naming server
		    //naming server will then make a call to running instance of service to be called
		    //first service now won't make a direct call to second service...
		    //now that is the job of naming server
		
		//And also we want load balancing among instances
		//if we create multiple instances of second service
		//then first service will make a call to naming server
		//naming server will to the load balancing and make a call to appropriate instance of second service
		
		
		
		//We would require a "eureka server" dependency in eurekaserver-application 
		//and for each microservice we need to add "eureka client" to talk to server
		
		//==========================================================================================
		
		//Changes in POM
		//1. Add eureka client dependency in dependencies section
		//2. Add dependencyManagement tag after the "dependencies" section
		//3. Add a <spring-cloud-version> tag inside the "properties" section
		//4. If you want to make call to another service, also add 
		//    this->"spring-cloud-starter-openfeign" dependency
		
		//Important
		//1. Simply adding "eureka-client" dependency in the POM will register this microservice with eureka
		//2. Writing @EnableFeignClients is compulsory if you use @FeignClient
		
		//==================================================================================================
		
		
		
		
		
		
		
	
		
		
		
	}

}
