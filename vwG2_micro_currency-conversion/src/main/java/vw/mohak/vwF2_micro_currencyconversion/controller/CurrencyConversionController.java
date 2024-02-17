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

@RestController

public class CurrencyConversionController {
	
	//we will not use restTemplate this time,....
	
	//we will make a call to eureka server using feign-client
	//adding eureka client dependency in POM does nothing....it just registers the app with eureka
	// so that eureka can keep a track on how many instances are running of the application
	
	//an implementing class will be injected here if we add "@EnableFiegnClients" in main app
	@Autowired
	CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	CurrencyConversion getCurrencyConversion
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
	
	

}
