package com.demo.CT.cart;

/*
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.cart.Cart;
import com.commercetools.api.models.cart.CartPagedQueryResponse;
import com.commercetools.api.models.cart.CartUpdate;
import com.commercetools.api.models.cart_discount.CartDiscount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
*/

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.cart.Cart;
import com.commercetools.api.models.cart.CartDraft;
import com.commercetools.api.models.cart.CartPagedQueryResponse;
import com.commercetools.api.models.cart.CartUpdate;
import com.commercetools.api.models.cart_discount.CartDiscount;
//import com.demo.CT.validate.DiscountCodeValidator;
import com.demo.CT.validate.DiscountCodeValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CartController {
    @Autowired
    ProjectApiRoot apiRoot;
    @Autowired
    CartService service;
    @Autowired
    DiscountCodeValidator discountCodeValidator;

   /* @PostMapping("/cartsh")
    public Cart createCart(@RequestBody CartInfo cartInfo, BindingResult bindingResult) {
        discountCodeValidator.validate(cartInfo, bindingResult);
        if (bindingResult.hasErrors()) {

            return null;
        } else {
            return service.createCart(cartInfo);
        }
    }*/


    @PostMapping("/cartsh")
    public Cart createCart(@RequestBody CartInfo cartInfo)
    {

       return service.createCart(cartInfo);
    }


    @GetMapping("/All")
    public CartPagedQueryResponse getAll() {
        return service.getall();
//        return apiRoot.carts().get().executeBlocking().getBody();
    }

    @GetMapping("/cart/{id}")
    public Cart getCartById(@PathVariable String id) {
        return apiRoot.carts().withId(id).get().executeBlocking().getBody();
    }


    @PostMapping("/update")
    public Cart updateCartById(@RequestBody CartInfo cartInfo) {
//        Cart cart = getCartById(id);
        return service.updateCart(cartInfo);
    }

    @DeleteMapping("/delete/{id}/{version}")
    public Cart deleteCart(@PathVariable String id, @PathVariable Long version) {
        return apiRoot.carts().withId(id).delete().withVersion(version).executeBlocking().getBody();
    }

    @PostMapping("/change-quantity/{id}")
    public Cart changeQuantityOfLineItem(@PathVariable String id, @RequestBody CartInfo cartInfo) {
        return service.changeQuantity(id, cartInfo);
//        return apiRoot.carts().withId(id).post((CartUpdate) cartInfo).executeBlocking().getBody();
    }

    /*@PostMapping("/discount code/{id}")
      public Cart createDiscountCode(@PathVariable String id,@RequestBody CartInfo cartInfo)
      {
          return service.addPromo(id,cartInfo);
      }*/
    @PostMapping("/cart-discount2")
    public CartDiscount createCartDiscount(@RequestBody CartInfo cartInfo,BindingResult bindingResult) {
        discountCodeValidator.validate(cartInfo,bindingResult);
        if(bindingResult.hasErrors()){
            return null;
        }else {
            return service.createCartDiscount2(cartInfo);
        }
    }

   /* public ZonedDateTime expire = null;
    public ZonedDateTime current = ZonedDateTime.now();*/

   /* @DeleteMapping("/filter")
    public CartDiscount filter(@RequestBody CartInfo cartInfo, BindingResult bindingResult) {

        expire = apiRoot.cartDiscounts().withId("b390e43d-d57b-444f-ace7-eb536d21d254").get().executeBlocking().getBody().getValidUntil();


        {
            discountCodeValidator.validate(cartInfo, bindingResult);
            if (expire.isAfter(current)) {

                return apiRoot.cartDiscounts().withId("b390e43d-d57b-444f-ace7-eb536d21d254").delete(4).executeBlocking().getBody();

            } else {
                return null;
            }

        }

    }*/
    @PostMapping("/aa/{id}")
    public Cart setShippingAddress(@RequestBody CartInfo cartInfo, @PathVariable String id)
    {
       return service.setShippingAddress(cartInfo,id);
    }

}





//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String,String> handleValidationExceptions(MethodArgumentNotValidException ex)
//    {
//        Map<String,String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error)-> {
//          String fieldName =((FieldError) error).getField();
//          String errorMessage = error.getDefaultMessage();
//          errors.put(fieldName,errorMessage);
//        });
//        return errors;
//    }



