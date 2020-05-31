package com.microservices.currencyconversionservice.controller;

import com.microservices.currencyconversionservice.dto.CurrencyConversion;
import com.microservices.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class CurrencyConversionController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @GetMapping(value = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversion> forEntity = restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
        CurrencyConversion currencyConversion = forEntity.getBody();
        return new CurrencyConversion(Objects.requireNonNull(currencyConversion).getId(), from, to, currencyConversion.getConversionRate(), quantity,currencyConversion.getConversionRate().multiply(quantity), currencyConversion.getPort());
    }

    @GetMapping(value = "/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
         CurrencyConversion currencyConversion = currencyExchangeServiceProxy.currencyExchange(from, to);
       logger.info("{}",currencyConversion);
        return new CurrencyConversion(Objects.requireNonNull(currencyConversion).getId(), from, to, currencyConversion.getConversionRate(), quantity,currencyConversion.getConversionRate().multiply(quantity), currencyConversion.getPort());
    }

    @GetMapping(value = "/currency-conversion-rest")
    public String convertCurrencyRest() {
        return currencyExchangeServiceProxy.dummyMethod();
    }


}
