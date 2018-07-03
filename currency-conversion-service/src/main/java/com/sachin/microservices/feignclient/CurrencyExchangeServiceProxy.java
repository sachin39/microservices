package com.sachin.microservices.feignclient;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sachin.microservices.configuration.LocalRibbonClientConfiguration;
import com.sachin.microservices.model.CurrencyconversionBean;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
@FeignClient(name = "currency-exchange-service")


/*
 * we want to configure what URLs the load for this services has to be
 * distributed between. This can be defined in application.properties
 */
//@RibbonClient(name = "currency-exchange-service", configuration = LocalRibbonClientConfiguration.class)


/*
 * Commented above line since we want to read servers details, on which
 * currency-exchange service is running from eureka server.
 */
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyconversionBean retrieveExchangeValue(@PathVariable("from") String from,
	    @PathVariable("to") String to);
}
