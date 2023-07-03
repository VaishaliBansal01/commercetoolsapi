package com.demo.CT.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor @Builder
public class CustomerDto {
   private String email;
    private String firstName;
    private  String lastName;
    private  String password;
    private  String emailP;
    private  String fildName;
    private  String customFieldName;
    private  String customLabel;
//    Boolean customRequired;
private  String customKey;
    private  String customTypeName;
    private  Long version;
    private  String tokenValue;
    private   String newPassword;
    private    String currentPassword;

    String id;
    Long ttlMinutes;


}