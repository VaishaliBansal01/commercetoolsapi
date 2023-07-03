package com.demo.CT.cart;

import com.commercetools.api.models.cart.LineItemDraft;
import com.commercetools.api.models.cart.TaxMode;
import com.commercetools.api.models.common.Money;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
@Valid
@Setter
@Getter
public class CartInfo {

   private String key;
   String currencyCode;
   Long centAmount;
   Long variantId;
    String sku;
   Long quantity;
  TaxMode taxMode;
  String id;
  Long version;
  private String discountCode;
  private ZonedDateTime validUntil;

  List<LineItemInfo> lineItems;
    String productId;
    String lineItemSku;

    String lineItemId;
    Long externalPrice;
    Long externalTotalPrice;
    String discountName;
    String discountKey;
    String discountDescription;

    Float discountValue;
    String dcode;
    String cartPredicate;
    String sortOrder;
    Boolean isActive;
    Boolean requiresDiscountCode;
    List<MoneyList> moneyList;

    ZonedDateTime zonedDateTime;

}
