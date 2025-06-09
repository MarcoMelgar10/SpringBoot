package com.pizza.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PizzaConfig {
    private String souce;
    private String topping;
    private String crust;
}
