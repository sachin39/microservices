package com.sachin.microservices.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sachin.microservices.model.CurrencyconversionBean;

@RestController
public class CurrencyConversionController {
    
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyconversionBean convertCurrency(
	    @PathVariable String from,
	    @PathVariable String to,
	    @PathVariable BigDecimal quantity) {
	Map<String, String> uriVariables =  new HashMap<>();
	uriVariables.put("from", from);
	uriVariables.put("to", to);
	ResponseEntity<CurrencyconversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyconversionBean.class, uriVariables);
	/*return new CurrencyconversionBean(1L, from, to, BigDecimal.ONE, quantity, quantity, 0);*/
	
	CurrencyconversionBean body = responseEntity.getBody();
	return new CurrencyconversionBean(body.getId(), body.getFrom(), body.getTo(), body.getConversionMultiple(),
		quantity, quantity.multiply(body.getConversionMultiple()), body.getPort());
    }
}
