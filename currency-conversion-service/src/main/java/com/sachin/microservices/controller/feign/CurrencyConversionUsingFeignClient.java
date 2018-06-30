package com.sachin.microservices.controller.feign;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sachin.microservices.feignclient.CurrencyExchangeServiceProxy;
import com.sachin.microservices.model.CurrencyconversionBean;

@RestController
public class CurrencyConversionUsingFeignClient {
    
    @Autowired
    private CurrencyExchangeServiceProxy feignProxy;

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyconversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
	    @PathVariable BigDecimal quantity) {
	
	CurrencyconversionBean response = feignProxy.retrieveExchangeValue(from, to);

	return new CurrencyconversionBean(response.getId(), response.getFrom(), response.getTo(), response.getConversionMultiple(),
		quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
    }

}
