package com.demo.CT.review;

import lombok.Data;

@Data
public class ReviewDto {
  private String key;
  private String stateKey;
   private String uniquenessValue;
   private String localizedString;
    private String authorName;
   private String title;
    private String text;
    private String id;
    private String stateId;
    private int rating;
    private String customerId;
    private String typeKey;
    private String typeName;
    private String resourceTypeId;

   private String customTypeKey;
    private String customFieldName;
    private String customFieldValue;

    String stateDescription;
    String stateName;
    String stateRoleEnum;

    Long version;




}
