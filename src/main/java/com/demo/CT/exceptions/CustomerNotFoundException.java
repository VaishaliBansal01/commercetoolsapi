package com.demo.CT.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerNotFoundException extends RuntimeException {
    private String message;
    public CustomerNotFoundException(String message)
    {
     super(message);
     this.message = message;
    }
}
