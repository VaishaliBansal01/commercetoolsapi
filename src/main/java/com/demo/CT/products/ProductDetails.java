package com.demo.CT.products;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ProductDetails {

    String productTypeKey;
    String key;
    String name;
    String slug;
    String sku;
    String description;
    String masterVariantKey;
    String masterVariantSku;
    String priceKey;
    String value;
    String countryCode;
    String channelKey;
    String currencyCode;
    Long centAmount;

    Long discountedValue;
    Boolean publish;
    String attributeName;
    Object attributeValue;
   Long version;
   Long variantId;





}