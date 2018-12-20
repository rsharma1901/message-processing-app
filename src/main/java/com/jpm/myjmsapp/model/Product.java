package com.jpm.myjmsapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class Product {
    int quantity;
    float ratePerItem;
}
