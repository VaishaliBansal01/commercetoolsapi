package com.demo.CT.products;

import com.commercetools.api.models.channel.ChannelResourceIdentifier;
import com.commercetools.api.models.common.*;
import com.commercetools.api.models.product.*;
import com.commercetools.api.models.product_type.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

//import static java.util.stream.Nodes.collect;

@Service
public class ProductService {

    ProductDataProvider pdp= new ProductDataProvider();

    public ProductType createProductType(ProductTypeDetails pd )
    {
        List<AttributeDefinitionDraft> add =pd.getAttributes().stream()
                .map (attributesData -> {
                            return AttributeDefinitionDraft
                                    .builder()
                                    .type(AttributeTypeBuilder::textBuilder)
                                    .name(attributesData.getAttributeName())

                                    .label(LocalizedString.ofEnglish(attributesData.getAttributeLabel()))
                                    .attributeConstraint(attributesData.getAttributeConstraints())
                                    .isRequired(attributesData.getIsRequired())
                                    .isSearchable(attributesData.getIsSearchable())
                                    .build();
                        })
                        .collect(Collectors.toList());


        ProductTypeDraft draft = ProductTypeDraft
                .builder()
                .name(pd.getName())
                .key(pd.getKey())
                .description(pd.getDescription())
                .attributes(add)
                .build();


//        ProductTypeDraft draft = ProductTypeDraft.builder()
//                .name(pd.getName()).description(pd.getDescription()).key(pd.getKey())
//                .build();

        return pdp.getProductType(draft);
    }

    public Product createProduct(ProductDetails productDetails)
    {

        ProductDraft productDraft = ProductDraft.builder()
                .productType(ProductTypeResourceIdentifier.builder().key(productDetails.getProductTypeKey()).build())
                .key(productDetails.getKey())
                .name(LocalizedString.ofEnglish(productDetails.getName()))
                .description(LocalizedString.ofEnglish(productDetails.getDescription()))
                .slug(LocalizedString.ofEnglish(productDetails.getSlug()))
                .masterVariant(ProductVariantDraftBuilder.of()
                        .key(productDetails.getMasterVariantKey())
                        .sku(productDetails.getMasterVariantSku())
                        .attributes(Attribute.builder().name(productDetails.getAttributeName())
                                .value(productDetails.getAttributeValue()).build()).build())
                .publish(productDetails.getPublish())
                .build();
        return pdp.createProduct(productDraft);
    }

    public Product updateProduct(String id ,ProductDetails productDetails)
    {
        ProductUpdate productUpdate = ProductUpdate.builder()
                .version(productDetails.getVersion())
                .actions(ProductUpdateAction.addPriceBuilder()
                        .variantId(productDetails.getVariantId())
                        .price(PriceDraft.builder().key(productDetails.getPriceKey())
                               .value(Money.builder().centAmount(productDetails.getCentAmount())
                                       .currencyCode(productDetails.getCurrencyCode()).build())
                               .country(productDetails.getCountryCode()) .build()).build())
                        .build();


        return pdp.updateProduct(id,productUpdate);
    }


   /* public ProductType createProductType(ProductTypeDetails details) {
        ProductTypeDraft productTypeDraft = ProductTypeDraft.builder()
                .key(details.getKey()).description(details.getDescription()).name(details.getName())
                .attributes(AttributeDefinitionDraft.builder().isRequired(details.attributes.get(0).getIsRequired())
                        .label(LocalizedString.ofEnglish(details.getAttributes().get(0).getAttributeLabel()))
                        .isSearchable(details.attributes.get(0).getIsSearchable()).type(AttributeTypeBuilder::textBuilder)
                        .name(details.attributes.get(0).getAttributeName()).build())
                .build();
        return pdp.getProductType(productTypeDraft);

    }*/
}