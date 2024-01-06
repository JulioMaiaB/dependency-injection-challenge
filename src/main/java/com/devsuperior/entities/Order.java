package com.devsuperior.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private int code;
    private Double basic;
    private Double discount;
}
