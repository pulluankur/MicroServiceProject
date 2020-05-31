package com.microservices.limitsservice.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class ConfigurationProperites {
    private Integer minValue;
    private Integer maxValue;

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        return "ConfigurationProperites{" +
                "minValue=" + minValue +
                ", maxValue=" + maxValue +
                '}';
    }
}
