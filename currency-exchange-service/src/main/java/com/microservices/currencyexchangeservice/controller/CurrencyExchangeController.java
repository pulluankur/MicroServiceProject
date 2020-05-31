package com.microservices.currencyexchangeservice.controller;

import com.microservices.currencyexchangeservice.dao.ExchangeValueRepository;
import com.microservices.currencyexchangeservice.dto.ExchangeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = "/")
public class CurrencyExchangeController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Environment environment;
    @Autowired
    ExchangeValueRepository exchangeValueRepository;

    @GetMapping(value = "currency-exchange/from/{from}/to/{to}")
    public ExchangeValue currencyExchange(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.valueOf(Objects.requireNonNull(environment.getProperty("local.server.port"))));
        logger.info("{}", exchangeValue);
        return exchangeValue;
    }

    @GetMapping("test")
    public String dummyMethod() {
        return "limit-server";
    }
}
