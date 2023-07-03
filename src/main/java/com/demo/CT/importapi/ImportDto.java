package com.demo.CT.importapi;

import lombok.Data;

@Data
public class ImportDto {

    String key;
    String type;
    String resources;
    String priceKey;
    String value;
    //product variant, product
    String productVariantKey;
    String typeId;
    String productKey;
    String typeIdProduct;
    Long centAmount;
    String currencyCode;

}
