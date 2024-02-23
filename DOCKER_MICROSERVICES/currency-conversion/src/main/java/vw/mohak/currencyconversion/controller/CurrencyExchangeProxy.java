package vw.mohak.currencyconversion.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vw.mohak.currencyconversion.entity.CurrencyConversion;

//Implementing this class is a duty of feign client
//"currency-exchange" name is the name of service which we gave in application proporties
//Fiegn client will search for the "currency-exchange" service name in 
//the naming registry of Eureka server

//@FeignClient(name="currency-exchange", url="localhost:8000")


@FeignClient(name = "currency-exchange")

public interface CurrencyExchangeProxy {
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	CurrencyConversion retrieveExchangeValue(@PathVariable String from,
			@PathVariable String to);

}
