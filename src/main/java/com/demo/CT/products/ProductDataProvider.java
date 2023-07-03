package com.demo.CT.products;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product.ProductDraft;
import com.commercetools.api.models.product.ProductUpdate;
import com.commercetools.api.models.product_type.ProductType;
import com.commercetools.api.models.product_type.ProductTypeDraft;
import com.demo.CT.config.CTConfiguration;

public class ProductDataProvider {
ProjectApiRoot apiRoot= CTConfiguration.createApiClient();
    public ProductType getProductType(ProductTypeDraft productTypeDraft) {
        return apiRoot.productTypes().post(productTypeDraft).executeBlocking().getBody();
    }

    public Product createProduct(ProductDraft productDraft) {
        return  apiRoot.products().post(productDraft).executeBlocking().getBody();
    }

    public Product updateProduct(String id,ProductUpdate productUpdate) {
        return apiRoot.products().withId(id).post(productUpdate).executeBlocking().getBody();
    }
}
