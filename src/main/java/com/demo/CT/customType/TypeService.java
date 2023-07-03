package com.demo.CT.customType;

import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.type.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeService {

    TypeDataProvider tdp = new TypeDataProvider();
    public Type createType(TypeDto typeDto)
    {
        FieldDefinition fieldDefinition = FieldDefinition
                .builder()
                .type(FieldType.stringBuilder().build())
                .name(typeDto.getFieldName())
                .inputHint(TypeTextInputHint.SINGLE_LINE)
                .label(LocalizedString.ofEnglish(typeDto.getLabel()))
                .required(typeDto.getRequired())
                .build();

// Create typeDraft with the FieldDefinition
         TypeDraft typeDraft = TypeDraft
                .builder()
                .key(typeDto.getKey())
                 .name(LocalizedString.ofEnglish(typeDto.getName()))
                .resourceTypeIds(ResourceTypeId.findEnum(typeDto.fieldType))
                .fieldDefinitions(List.of(fieldDefinition))
                .build();
         return tdp.createType(typeDraft);
    }
}
