package com.demo.CT.customType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commercetools.api.models.type.*;

@RestController
public class TypeController {
    @Autowired
    TypeService ts;
    @PostMapping("/customtype")
   public Type createType(@RequestBody TypeDto typeDto)
    {

        return ts.createType(typeDto);
    }
}
