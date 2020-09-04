package com.fiap.aoj.netflix.suporte.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Usuario implements Serializable {

    private String identifier;
    private String customer;
    private BigDecimal value;
}
