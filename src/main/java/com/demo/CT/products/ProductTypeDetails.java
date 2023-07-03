package com.demo.CT.products;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductTypeDetails {
    String name;
    String description;
    String key;

    List<AttributesData> attributes;
}
