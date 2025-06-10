package com.pizza.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix ="pizza")
@Configuration
@AllArgsConstructor
@Data
@NoArgsConstructor
public class PizzaConfig {
    private String sauce;
    private String topping;
    private String crust;
}
