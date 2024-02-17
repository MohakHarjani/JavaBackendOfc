package vw.mohak.vwF2_micro_currencyconversion.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vw.mohak.vwF2_micro_currencyconversion.entity.CurrencyConversion;


//Implementing this interface is a duty of feign client
//"currency-exchange" name is the name of service which we gave in application proporties
//Fiegn client will search for the "currency-exchange" service name in 
//  the naming registry of Eureka server
//Fiegn client will load balance requests to instnces of "currency-exchange"

@FeignClient("currency-exchange") //write the exact "name" of the microservice which you want to call
public interface CurrencyExchangeProxy {
	
	//this get call will be made by feign-client to eureka
	//eureka will return the load balanced instance's port number
	//the feign will in turn make a get call to that port
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion getCurrencyExchange (@PathVariable String from, @PathVariable String to);

}
