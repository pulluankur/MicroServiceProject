package com.microservices.currencyexchangeservice.dao;

import com.microservices.currencyexchangeservice.dto.ExchangeValue;
import org.springframework.data.repository.CrudRepository;

public interface ExchangeValueRepository extends CrudRepository<ExchangeValue, Integer> {

    ExchangeValue findByFromAndTo(String from, String to);
}
