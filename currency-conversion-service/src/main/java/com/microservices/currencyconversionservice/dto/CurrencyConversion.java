package com.microservices.currencyconversionservice.dto;

import java.math.BigDecimal;

public class CurrencyConversion {
    private Integer id;
    private String from;
    private String to;
    private BigDecimal conversionRate;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;
    private Integer port;

    public CurrencyConversion() {
    }

    public CurrencyConversion(Integer id, String from, String to, BigDecimal conversionRate, BigDecimal quantity, BigDecimal totalCalculatedAmount, Integer port) {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionRate = conversionRate;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.port = port;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "CurrencyConversion{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionRate=" + conversionRate +
                ", quantity=" + quantity +
                ", totalCalculatedAmount=" + totalCalculatedAmount +
                ", port=" + port +
                '}';
    }
}

