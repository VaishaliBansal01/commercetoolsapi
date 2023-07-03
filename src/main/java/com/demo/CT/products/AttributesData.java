package com.demo.CT.products;

import com.commercetools.api.models.product_type.AttributeConstraintEnum;
import com.commercetools.api.models.product_type.AttributeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttributesData {

    AttributeType attributeType;
    String attributeName;
    String attributeValue;
    String attributeLabel;
    String attributeDescription;
    AttributeConstraintEnum attributeConstraints;

    Boolean isSearchable;
    Boolean isRequired;
}
