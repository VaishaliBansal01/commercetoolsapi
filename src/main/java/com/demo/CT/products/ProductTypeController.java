package com.demo.CT.products;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.graph_ql.GraphQLRequest;
import com.commercetools.api.models.graph_ql.GraphQLResponse;
import com.commercetools.api.models.graph_ql.GraphQLVariablesMap;
import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product.ProductDraft;
import com.commercetools.api.models.product.ProductPagedQueryResponse;
import com.commercetools.api.models.product.ProductProjection;
import com.commercetools.api.models.product_type.ProductType;
import com.demo.CT.config.CTConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ProductTypeController {

//   ProjectApiRoot apiRoot = CTConfiguration.createApiClient();
@Autowired
ProjectApiRoot projectApiRoot;

    @Autowired
    ProductService ps;
    @PostMapping("/type")
    public ProductType getProductType(@RequestBody ProductTypeDetails details)
    {
       ProductType type= ps.createProductType(details);
        return type;
    }
@PostMapping("/create-product")
    public Product createProduct(@RequestBody ProductDetails productDetails)
    {

        return ps.createProduct(productDetails);
    }
    @GetMapping("/Get-allproduct")
    public ProductPagedQueryResponse getAllProducts()
    {
        return  projectApiRoot.products().get().executeBlocking().getBody();
    }

    /*public ProductProjection productSortByPrice()
    {
       List<ProductPagedQueryResponse> pagedQueryResponses= (List<ProductPagedQueryResponse>) getAllProducts();
        pagedQueryResponses.stream().map(productPagedQueryResponse ->
                productPagedQueryResponse.withProductPagedQueryResponse(ProductPagedQueryResponse::getResults));
        List<Product> productList = List<>



    }*/
    @GetMapping("/Get-allproduct/graphql")
    public GraphQLResponse getAllProductsGraplql()
    {
        return  projectApiRoot.graphql().post(GraphQLRequest.builder().query("query Sphere {\n" +
                "  products(limit: 2) {\n" +
                "    ...StagedProduct\n" +
                "    ...CurrentProduct\n" +
                "   \n" +
                "  }\n" +
                "}\n" +
                "fragment Product on ProductData {\n" +
                "  skus, name(locale: \"en\")\n" +
                "}\n" +
                "fragment StagedProduct on ProductQueryResult {\n" +
                "  results {\n" +
                "    id, masterData { staged { ...Product } }\n" +
                "  }\n" +
                "}\n" +
                "fragment CurrentProduct on ProductQueryResult {\n" +
                "  results {\n" +
                "    id, masterData { current { ...Product } }\n" +
                "  }\n" +
                "}\n").build()).executeBlocking().getBody();

    }
    @GetMapping("/productt/{id}")
    public Product getProductById(@PathVariable String id)
    {
        return projectApiRoot.products().withId(id).get().executeBlocking().getBody();
    }

    @PostMapping("/updateproduct/{id}")
    public Product updateProduct(@PathVariable String id ,@RequestBody ProductDetails productDetails)
    {
        return ps.updateProduct(id,productDetails);
    }
@DeleteMapping("/deleteproduct/{key}/{version}")
    public Product deleteProduct(@PathVariable String key, @PathVariable Long version)
    {

        return projectApiRoot.products().withKey(key).delete().addVersion(version).executeBlocking().getBody();
    }
    @GetMapping("/prooductid/graphql")
    public GraphQLResponse queryProductId()
    {
        return projectApiRoot.graphql().post(GraphQLRequest.builder().query("query Vaishali($sku:String) {\n" +
                "  product(sku:$sku){\n" +
                "   id\n" +
                "   }\n" +
                "}").variables(GraphQLVariablesMap.builder().addValue("sku","SKU2023").build()).build()).executeBlocking().getBody();
    }


}
