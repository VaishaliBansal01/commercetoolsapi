package com.demo.CT.cart;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.cart.Cart;
import com.commercetools.api.models.cart.CartDraft;
import com.commercetools.api.models.cart.CartPagedQueryResponse;
import com.commercetools.api.models.cart.CartUpdate;
import com.commercetools.api.models.cart_discount.CartDiscount;
import com.commercetools.api.models.cart_discount.CartDiscountDraft;
import com.demo.CT.config.CTConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartDataProvider {


            ProjectApiRoot apiRoot= CTConfiguration.createApiClient();


    public Cart getCart(CartDraft cartDraft) {
        return apiRoot.carts().post(cartDraft).executeBlocking().getBody();
    }

    public Cart getUpdatedCart(String id, CartUpdate cartUpdate) {


        return apiRoot.carts().withId(id).post(cartUpdate).executeBlocking().getBody();
    }

    public Cart getChangedQuantity(String id, CartUpdate cartUpdate ) {

        return apiRoot.carts().withId(id).post(cartUpdate).executeBlocking().getBody();
    }

    public CartPagedQueryResponse getall() {
        return apiRoot.carts().get().executeBlocking().getBody();
    }

    public Cart getDiscountCode(String id, CartUpdate cartUpdate) {
        return apiRoot.carts().withId(id).post(cartUpdate).executeBlocking().getBody();
    }

    public CartDiscount rtgh(CartDiscountDraft cartDiscountDraft) {
        return apiRoot.cartDiscounts().post(cartDiscountDraft).executeBlocking().getBody();
    }

    public Cart setShippingAddress(CartUpdate cartUpdate, String id) {
        return  apiRoot.carts().withId(id).post(cartUpdate).executeBlocking().getBody();
    }
}
