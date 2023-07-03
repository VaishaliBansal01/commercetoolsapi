package com.demo.CT.validate;


import com.demo.CT.cart.CartInfo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.ZonedDateTime;

@Component
public class DiscountCodeValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

//    @Override
//    public void validate(Object target, Errors errors) { //cartInfo datahoga error me null bindiandg object hoga
////importent this method always need to call for validate
////        CartInfo cartInfo = (CartInfo)target;

//        if(cartInfo.getIsActive().equals(false)){
//            errors.rejectValue("isActive","vaishali");
//        }
//    }
    @Override
    public void validate(Object target, Errors errors)
    {
        CartInfo cartInfo = (CartInfo) target;
        ZonedDateTime now= ZonedDateTime.now();
        if (cartInfo.getValidUntil().isBefore(now))
        {

            errors.rejectValue("discountCode","kuchh bhi");
        }
    }

}




