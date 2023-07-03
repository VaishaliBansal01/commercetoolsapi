package com.demo.CT.importapi;

import com.commercetools.importapi.models.common.ProductKeyReference;
import com.commercetools.importapi.models.common.ProductVariantKeyReference;
import com.commercetools.importapi.models.common.TypedMoney;
import com.commercetools.importapi.models.common.TypedMoneyBuilder;
import com.commercetools.importapi.models.importcontainers.ImportContainer;
import com.commercetools.importapi.models.importcontainers.ImportContainerDraft;
import com.commercetools.importapi.models.importrequests.ImportResponse;
import com.commercetools.importapi.models.importrequests.PriceImportRequest;
import com.commercetools.importapi.models.prices.PriceImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class ImportService {
    @Autowired
    ImportDao importDao;
    public ImportContainer createImportContainer(ImportDto importDto) {
        ImportContainerDraft importContainerDraft = ImportContainerDraft
                .builder()
                .key(importDto.getKey())
                .build();
        return importDao.createImportContainer(importContainerDraft);
    }

    public ImportResponse createPriceImportRequest(String key,ImportDto importDto) {
       PriceImportRequest priceImportRequest = PriceImportRequest
               .builder()
               .resources(PriceImport.builder().key(importDto.getPriceKey())
                       .value(TypedMoney.centPrecisionBuilder()
                               .centAmount(importDto.getCentAmount())
                               .currencyCode(importDto.getCurrencyCode()).build())
                       .productVariant(ProductVariantKeyReference.builder()
                               .key(importDto.getProductVariantKey())
                               .build())
                       .product(ProductKeyReference.builder().key(importDto.getProductKey()).build())
                       .build()
               )

               .build();
       return importDao.createPriceImportRequest(key,priceImportRequest);
    }
}
