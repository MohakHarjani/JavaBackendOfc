package vw.mohak.vwF1_micro_currencyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vw.mohak.vwF1_micro_currencyexchange.entity.CurrencyExchange;
import vw.mohak.vwF1_micro_currencyexchange.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	CurrencyExchangeRepository cr;
	
	@Autowired
	Environment env;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	CurrencyExchange getCurrencyExchange(@PathVariable String from, @PathVariable String to)
	{
		CurrencyExchange currencyExchange = cr.findByFromAndTo(from, to);
		if (currencyExchange == null)
			throw new RuntimeException("Unable to find data for => " + from  + " to " + to);
		
		//port isn't a field in table but it is a field in entity (pojo)
		String currentPort = env.getProperty("local.server.port");
		currencyExchange.setPort(currentPort);
		
		return currencyExchange;
	}

}
