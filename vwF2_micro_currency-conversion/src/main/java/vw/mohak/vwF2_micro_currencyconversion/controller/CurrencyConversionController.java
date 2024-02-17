package vw.mohak.vwF2_micro_currencyconversion.controller;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import vw.mohak.vwF2_micro_currencyconversion.entity.CurrencyConversion;

@Configuration
class RestTemplateConfiguration{
	
	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder)    
	{
		//bean of RestTemplate builder will be automatically injected
		
		return builder.build();
	}
	
}
@RestController
public class CurrencyConversionController {
	
	 //RestTemplate class is used to make call just like postman
	
	//making a object of RestTemplate also would work completely fine....
	//RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	RestTemplate restTemplate ;
	//bean of RestTemplate (made by us only :( )will be injected by container
	
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	CurrencyConversion getCurrencyConversion
	(
			@PathVariable String from, 
			@PathVariable String to, 
			@PathVariable BigDecimal quantity
	)
	{
		
		//now we have to make a call to currency-exchange microservice
		//here make a  hardcoded port call to exchange-service using restTemplate
		
		Map<String, String>uriVariableMap = new HashMap<String, String>();
		uriVariableMap.put("from", from);
		uriVariableMap.put("to", to);
		
		//synchoronous get call
		ResponseEntity<CurrencyConversion> responseEntity = 
				restTemplate.getForEntity
				(
						"http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
						CurrencyConversion.class, 
						uriVariableMap	
				);
		
		//   # Call on URL will return an object of CurrencyExchange 
		//     because we have mentioned in getEntity call to mao response in CurrencyConversion
		//   # We don't have CurrencyExchange class from diff microservice
		//   # But we can collect it in CurrencyConversion (as it has all variables of exchng)
	    //      as CurencyConversion has all variables of currency-exchng + extra variables
		//      extra variables will be default (blank/null)
		
		
		CurrencyConversion currencyConversion = responseEntity.getBody();
		//but this object doesn't have the result(totalCalculateAmount populated)
		
		//populating the required fields
		currencyConversion.setQuantity(quantity);
		BigDecimal convertedAmount = quantity.multiply(currencyConversion.getConversionMultiple());
		currencyConversion.setTotalCalculatedAmount(convertedAmount);
		
		return currencyConversion;		
	}
	
	

}
