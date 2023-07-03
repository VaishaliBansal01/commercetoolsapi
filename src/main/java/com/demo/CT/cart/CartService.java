package com.demo.CT.cart;

import com.commercetools.api.models.cart.*;
import com.commercetools.api.models.cart_discount.*;
import com.commercetools.api.models.common.BaseAddress;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.common.Money;
import com.commercetools.api.models.discount_code.DiscountCode;
import com.commercetools.api.models.discount_code.DiscountCodeDraft;
import com.commercetools.api.models.product.ProductResourceIdentifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

  CartDataProvider provider = new CartDataProvider();
    public Cart createCart(CartInfo cartInfo)
    {
        List<LineItemDraft> a = cartInfo.getLineItems().stream().map(e -> {
            return LineItemDraft.builder()
                    .productId(e.getProductId())
                    .sku(e.getSku())
                    .quantity(e.getQuantity())
                    .build();
        } )
                .collect(Collectors.toList());



        CartDraft cartDraft = CartDraft.builder()
                .key(cartInfo.getKey())
                .currency(cartInfo.getCurrencyCode())
                .taxMode(TaxMode.DISABLED)
                .lineItems(a)
                .build();
        return provider.getCart(cartDraft);
    }

    public Cart updateCart(CartInfo cartInfo)
    {
        String id = cartInfo.getId();
        CartUpdate  cartUpdate = CartUpdate.builder()
                .actions(CartUpdateAction.addLineItemBuilder()
                        .quantity(cartInfo.getQuantity()).sku(cartInfo.getSku()).build())
                .version(cartInfo.getVersion())
          .build();
            return provider.getUpdatedCart(id,cartUpdate);
    }

  /*  public LineItem addingLineItem()
    {
        LineItemDraft draft = LineItemDraft.builder().build()
        return
    }*/
   public Cart changeQuantity(String id,CartInfo cartInfo)
   {
       CartUpdate cartUpdate = CartUpdate.builder()
               .version(cartInfo.getVersion())
               .actions(CartChangeLineItemQuantityAction.builder()
                       .lineItemId(cartInfo.getLineItemId())
                       .quantity(cartInfo.getQuantity())
                       .build())
               .build();
    return provider.getChangedQuantity(id,cartUpdate);
   }


    public CartPagedQueryResponse getall() {
       return provider.getall();
    }

    public CartDiscount createCartDiscount(CartInfo cartInfo)
    {
        CartDiscountDraft cartDiscountDraft = CartDiscountDraft
                .builder()
                .name(LocalizedString.ofEnglish(cartInfo.getDiscountName()))
                .key(cartInfo.getDiscountKey())
                .description(LocalizedString.ofEnglish(cartInfo.getDiscountDescription()))
                .value(CartDiscountValueGiftLineItemDraftBuilder.of()
                        .product(ProductResourceIdentifier.builder()
                                .id(cartInfo.getProductId()).build())
                                .variantId(cartInfo.getVariantId()).build())

//                        .money(Money.builder().currencyCode(cartInfo.getCurrencyCode())
//                                .centAmount(cartInfo.getCentAmount()).build()).build())
                .cartPredicate(cartInfo.getCartPredicate())
                .sortOrder(cartInfo.getSortOrder())
                .isActive(cartInfo.getIsActive())
                .requiresDiscountCode(cartInfo.getRequiresDiscountCode())
                .build();
return provider.rtgh(cartDiscountDraft);
    }
    public CartDiscount createCartDiscount2(CartInfo cartInfo)
    {
        CartDiscountDraft cartDiscountDraft = CartDiscountDraft
                .builder()
                .name(LocalizedString.ofEnglish(cartInfo.getDiscountName()))
                .key(cartInfo.getDiscountKey())
                .description(LocalizedString.ofEnglish(cartInfo.getDiscountDescription()))
                .value(CartDiscountValueAbsoluteDraft.builder()
                        .withMoney(moneyBuilder -> moneyBuilder.currencyCode(cartInfo.getCurrencyCode())
                                .centAmount(cartInfo.getCentAmount())).build())
               /* .validFrom(ZonedDateTime.parse("2022-01-01"))
                .validUntil(ZonedDateTime.parse("2022-12-14"))*/
//                .cartPredicate(cartInfo.getCartPredicate())
                .cartPredicate(cartInfo.getCartPredicate())
                .target(CartDiscountTarget.lineItemsBuilder().predicate(cartInfo.getCartPredicate()).build())
                .sortOrder(cartInfo.getSortOrder())
                .isActive(cartInfo.getIsActive())

                .requiresDiscountCode(cartInfo.getRequiresDiscountCode())
                .build();
        return provider.rtgh(cartDiscountDraft);
    }
   /* public Cart createDiscountCode(CartInfo cartInfo)
    {
        DiscountCodeDraft discountCodeDraft = DiscountCodeDraft.builder()
                .build();

    }*/

    public Cart setShippingAddress(CartInfo cartInfo, String id){
        CartUpdate cartUpdate = CartUpdate.builder()
                .version(cartInfo.getVersion())
                .actions(CartUpdateAction.setShippingAddressBuilder()
                        .address(BaseAddress.builder()
                                .country("IN")
                                .build())
                        .build())

                .build();
        return provider.setShippingAddress(cartUpdate,id);
    }

}
