package vw.mohak.vwH3_micro_apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder)
	{
		
		//builder.routes() returns a "Builder"
		//calling ".route()" on a builder will in turn return a "Builder"
		//so we can chain many ".route()"
		//And if we call ".build()" on any Builder object it will return a "RouteLocator"
		
		
		//  we typed this "localhost:8765/currency-exchange/from/USD/to/INR" [after localhost is the route]
		//  we need to route this to "localhost:8000/currency-exchange/from/USD/to/INR"
		//  there are two ways of doing this
		
		//  1. p.path("/currency-exchange/**").uri("localhost:8000")
		//     this will append the path to the given uri and route it there
		//     so it will route this to "localhost:8000/" + "currency-exchange/**"
		//                                = "localhost:8000/currency-exchange/**"
		
		
		// 2. p.path("/currency-exchange/**).uri("lb://currency-exchange-service")
		//    this uses eureka server to get the port of "currency-exchange-service"
		//    it will get the load balanced port from eureka's naming registry based on name of service
		//    then it will ultimately resolve to "localhost:8000" or "localhost:8001" (load balance)
		//    then will append the path to this port
		//         "localhost:8000" + "/currency-exchange/**"
		//    
		//  this needs to be routed to "currency-exchange-service"
		//  
		
		return builder.routes()
		       .route(
		    		   (p)->p.path("/currency-exchange/**")     
		    		         .uri("lb://currency-exchange-service")
		    		 )
		       
		       .route(
		    		   (p)->p.path("/currency-conversion/**")
		    		          .uri("lb://currency-conversion-service")
		    		 )
		       
		      
		       .route(
		    		   (p)->p.path("/currency-conversion-feign/**")
		    		         .uri("lb://currency-conversion-service")
		    		 )
		       
		       .route(
		    		    (p)->p.path("/currency-conversion-new/**")  //adding a wrong URL
		    		          .filters((f)->f.rewritePath(
		    		        		            "/currency-conversion-new/(?<segment>.*)", 
								                 "/currency-conversion-feign/${segment}"))
		    		          .uri("lb://currency-conversion-service")
		    		        		  
		    		 )
		       
		       .route(p -> p
						.path("/get")
						.filters(f -> f
								.addRequestHeader("MyHeader", "MyURI")
								.addRequestParameter("Param", "MyValue"))
						.uri("http://httpbin.org:80"))
		       
		      
		       .build();
		
		
		
		

	}
}
