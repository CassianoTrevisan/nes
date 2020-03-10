package com.cassiano.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnomalyConfig {
    private String parentPattern;
    private Double limit;
}
