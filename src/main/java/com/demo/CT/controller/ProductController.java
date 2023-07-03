package com.demo.CT.controller;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product.ProductDraft;
import com.commercetools.api.models.product.ProductPagedQueryResponse;
import com.commercetools.api.models.product.ProductProjectionPagedSearchResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {
    @Autowired
    ProjectApiRoot projectApiRoot;

    @GetMapping("/products")
    ProductPagedQueryResponse productGetById()
    {
        return projectApiRoot.products().get().addLimit(47).executeBlocking().getBody();
    }
    /*@GetMapping("/products")
    ProductPagedQueryResponse getProductByLimit(@RequestParam(required = true) int limit)
    {
        return projectApiRoot.products().get().withLimit(limit).executeBlocking().getBody();
    }*/

    @GetMapping("/product/{key}")
    Product getProductByKey(@PathVariable String key)
    {
      return projectApiRoot.products().withKey(key).get().executeBlocking().getBody();
    }

//    @GetMapping("/FilterKey")
//    ProductPagedQueryResponse getProductsByKeywhere(@RequestParam String where)
//    {
//        return projectApiRoot.products().get().addWhere(where).executeBlocking().getBody();
//        //return projectApiRoot.productProjections().search().get().addFilter("productType.id:\"03b23dde-90d1-4ec6-bb8e-f45c72f5f6ee\"").executeBlocking().getBody();
//    }

    @GetMapping("/Filter")
    ProductProjectionPagedSearchResponse getProductsByFilter()
    {
      return projectApiRoot.productProjections().search().get().addFilter("productType.id:\"03b23dde-90d1-4ec6-bb8e-f45c72f5f6ee\"").executeBlocking().getBody();
    }


    @GetMapping("/products/filter")
    ProductPagedQueryResponse getProductsByAttribute(@RequestParam String Where)
    {
        return projectApiRoot.products().get().addWhere(Where).executeBlocking().getBody();
    }

    //1. how to pass multiple values for the same attribute
    @GetMapping("/multivalue")

    ProductProjectionPagedSearchResponse getProductsByPassingMultivalueForSameAttribute(@RequestParam String sort)
    {
        return projectApiRoot.productProjections().search().get().addFilter(sort).executeBlocking().getBody();
    }

    //2. multiple fitlers in search
    @GetMapping("/Multi Filter")
    ProductProjectionPagedSearchResponse getProductsByMultiFilter(@RequestParam String punam,@RequestParam String aakriti )
      {
          return projectApiRoot.productProjections().search().get().addFilter(punam).addFilter(aakriti).executeBlocking().getBody();
      }






}


