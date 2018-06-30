package com.sachin.microservices.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sachin.microservices.model.CurrencyconversionBean;

@FeignClient(name="currency-exchange-service", url="localhost:8000")
public interface CurrencyExchangeServiceProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyconversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
