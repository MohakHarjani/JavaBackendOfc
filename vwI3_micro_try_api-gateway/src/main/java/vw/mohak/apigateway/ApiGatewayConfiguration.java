package vw.mohak.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	 @Bean
	    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
	        return builder.routes()
	                .route(r -> r.path("/employee/**")
	                		     .filters(
	                		    		    (f)-> f.addRequestParameter("name", "Mohak")
	                		    		           .addResponseHeader("response", "Hi from server")
	                		    		 )
	                             .uri("http://localhost:8000/")
	                       )
	                      

	                .route(r -> r.path("/user/**")
	                        .uri("http://localhost:8001/")
	                        )
	                
	                .build();
	    }

	
	
	
}
