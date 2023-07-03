package com.demo.CT.customersigninsignup;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
public class CustomerDTO {
    String email;
    String firstName;
    String lastName;
    @NotNull
    String password;

}
