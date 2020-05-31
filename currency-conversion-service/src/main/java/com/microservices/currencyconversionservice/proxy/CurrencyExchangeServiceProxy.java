package com.microservices.currencyconversionservice.proxy;


import com.microservices.currencyconversionservice.dto.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "curreny-exchange-service", url = "http://localhost:8000")
//@FeignClient(name = "curreny-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "curreny-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping(value = "/curreny-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion currencyExchange(@PathVariable String from, @PathVariable String to);

    @GetMapping("test")
    String dummyMethod();
}
