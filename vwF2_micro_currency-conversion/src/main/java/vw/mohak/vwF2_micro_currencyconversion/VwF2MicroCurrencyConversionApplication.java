package vw.mohak.vwF2_micro_currencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VwF2MicroCurrencyConversionApplication {

	public static void main(String[] args) {
		
		//GOAL OF vwF1_currency-exchange & vwF2_currency-conversion
		//We want to create two microservices and want one micro to call to other micro internally
		
		//1. currency-exchange creates an entity and stores data in a table in mysql...
		//     table stores exchange-rate bw two currencies (just that.... :) )
		
		//2. curreny-conversion converts the given quantity from one currency to other
		//   but to get conversion rate etc... it calls "currency-exchange" internally
		//   so currency-conversion will call currency exchange using "restTemplate"
		
		//   in this proj, we will use a "harcoded" url to call currency-exchange 
		
		SpringApplication.run(VwF2MicroCurrencyConversionApplication.class, args);
	}

}
