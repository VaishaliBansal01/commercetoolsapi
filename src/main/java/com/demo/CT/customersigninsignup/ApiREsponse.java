package com.demo.CT.customersigninsignup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ApiREsponse {

    private String message;
    private Boolean success;
 //   private HttpStatus status;
}
