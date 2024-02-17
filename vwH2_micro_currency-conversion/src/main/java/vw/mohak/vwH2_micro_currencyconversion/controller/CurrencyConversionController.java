package vw.mohak.vwH2_micro_currencyconversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import vw.mohak.vwH2_micro_currencyconversion.entity.CurrencyConversion;

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
	
	
	//=======================================================================================
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
		
		CurrencyConversion currencyConversion = responseEntity.getBody();
		//but this object doesn't have the result(totalCalculateAmount populated)
		
		//populating the required fields
		currencyConversion.setQuantity(quantity);
		BigDecimal convertedAmount = quantity.multiply(currencyConversion.getConversionMultiple());
		currencyConversion.setTotalCalculatedAmount(convertedAmount);
		
		return currencyConversion;		
	}
	

	//=================================================================================================
	@Autowired
	CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	CurrencyConversion getCurrencyConversionFeign
	(
			@PathVariable String from, 
			@PathVariable String to, 
			@PathVariable BigDecimal quantity
	)
	{		
		CurrencyConversion currencyConversion = proxy.getCurrencyExchange(from, to);

		currencyConversion.setQuantity(quantity);
		BigDecimal convertedAmount = quantity.multiply(currencyConversion.getConversionMultiple());
		currencyConversion.setTotalCalculatedAmount(convertedAmount);
		
		return currencyConversion;		
	}
	
	//=======================================================================================================
	
	

}
