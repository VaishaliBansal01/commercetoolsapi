package com.demo.CT.state;

import com.commercetools.api.models.state.StateTypeEnum;
import lombok.Data;

@Data
public class StateDTO {
    String key;

    StateTypeEnum type;
    Boolean initial;

    String transitionKey;
}
