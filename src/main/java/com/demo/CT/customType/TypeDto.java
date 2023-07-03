package com.demo.CT.customType;

import com.commercetools.api.models.common.LocalizedString;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class TypeDto {
    String key;
    String name;
    List resourceTypeId;

    String fieldType;
    String fieldName;
   String label;
    Boolean required;

}
