package com.sachin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sachin.model.ExchangeValue;
import com.sachin.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
   
    @Autowired
    private ExchangeValueRepository repository;
    
    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

	ExchangeValue exchangeValue = repository.findUsingHQL(from, to);
	
	exchangeValue.setPort(
		Integer.parseInt(environment.getProperty("local.server.port")));
	
	System.out.println("Exchange value: "+exchangeValue);
	//exchangeValue.setPort(8000);
	return exchangeValue;
    }

}
