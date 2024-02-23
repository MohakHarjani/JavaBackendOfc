package vw.mohak.currencyconversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import vw.mohak.currencyconversion.entity.CurrencyConversion;

//@Configuration(proxyBeanMethods=false)
@Configuration
class RestTemplateConfiguration {
	
	@Bean
	RestTemplate restTemplate (RestTemplateBuilder builder)
	{
		return builder.build();
	}

	
	
}
@RestController
public class CurrencyConversionController {
	
	
	//for testing rest service
	//here we use to to test the other microservice from this one
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CurrencyExchangeProxy proxy;
	
	Logger lg = LoggerFactory.getLogger(getClass());

	@GetMapping ("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion
	(
			@PathVariable String from, 
			@PathVariable String to, 
			@PathVariable BigDecimal quantity
	)
	{
		HashMap<String, String>uriVariables = new HashMap();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		lg.info("Conversion " + uriVariables);
		
		
		//hardcoded port number....
		//synchoronous get call
		ResponseEntity<CurrencyConversion> responseEntity = 
		    restTemplate.getForEntity  
			(
			   "http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
			    CurrencyConversion.class, 
			    uriVariables
			);
		
		//Call on URL will return an object of CurrencyExchange
		//But we don't have CurrencyExchange class from diff microservice
		//But we can collect it in CurrencyConversion (as it has all variables of exchng)
		//as CuurencyConversion has all variables of currency-exchng + extra variables
		//extra variables will be default (blank/null)
		
		CurrencyConversion currencyConversion = responseEntity.getBody();
		
		lg.info("Conversion => " + currencyConversion);
		return new CurrencyConversion
		(
			currencyConversion.getId(), 
			from, 
			to, 
			quantity, 
			currencyConversion.getConversionMultiple(),
			quantity.multiply(currencyConversion.getConversionMultiple()),
			currencyConversion.getEnvironment()
		);
		
		
	}
	//===================================================================

	@GetMapping ("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign
	(
			@PathVariable String from, 
			@PathVariable String to, 
			@PathVariable BigDecimal quantity
	)
	{

		CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);
		
		lg.info("Conversion:feign => " + currencyConversion);
		return new CurrencyConversion
		(
			currencyConversion.getId(), 
			from, 
			to, 
			quantity, 
			currencyConversion.getConversionMultiple(),
			quantity.multiply(currencyConversion.getConversionMultiple()),
			currencyConversion.getEnvironment()
		);
		
		
	}
	
}
