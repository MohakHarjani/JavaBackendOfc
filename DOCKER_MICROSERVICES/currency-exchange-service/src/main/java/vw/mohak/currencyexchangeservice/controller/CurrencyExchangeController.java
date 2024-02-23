package vw.mohak.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vw.mohak.currencyexchangeservice.entity.CurrencyExchange;
import vw.mohak.currencyexchangeservice.repository.CurrencyExchangeRepository;


@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository cr;
	
	
	//similar to port + IP addr (here ip addr is same)
	@Autowired
	private Environment environment;

	
	private Logger lg = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
			@PathVariable String to) 
	{
//		lg.info("retrieveExchangeValue called with {} to {}", from, to);
		CurrencyExchange currencyExchange = cr.findByFromAndTo(from, to);
	if(currencyExchange ==null) {
			throw new RuntimeException
				("Unable to Find data for " + from + " to " + to);
		}
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
	
}
