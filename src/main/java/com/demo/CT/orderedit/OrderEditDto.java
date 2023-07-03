package com.demo.CT.orderedit;


import com.commercetools.api.models.order.StagedOrderUpdateAction;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class OrderEditDto {

    private String key;
//    private String orderId;
    private String referenceTypeId;
    List<StagedOrderUpdateAction> stagedOrderUpdateActions;

    String email;
    Long editVersion;
    Long resourceVersion;


}
