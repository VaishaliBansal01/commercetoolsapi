package com.demo.CT.review;

import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.common.ResourceIdentifier;
import com.commercetools.api.models.customer.CustomerResourceIdentifier;
import com.commercetools.api.models.review.Review;
import com.commercetools.api.models.review.ReviewDraft;
import com.commercetools.api.models.review.ReviewUpdate;
import com.commercetools.api.models.review.ReviewUpdateAction;
import com.commercetools.api.models.state.*;
import com.commercetools.api.models.type.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReviewService {

    ReviewDataProvider rdp = new ReviewDataProvider();
    public Review createReview(ReviewDto reviewDto)
    {
       /* FieldContainer dkf= FieldContainer.builder()
            .addValue("fildcontainerkey7","1" )
            .addValue("fildcontainerkey6", "2")
            .addValue("fildcontainerkey5", "3")
            .build();
*/
//        TypeResourceIdentifier sdkmf  =TypeResourceIdentifier.builder().key(reviewDto.getTypeKey()).build();

//        CustomFieldsDraft dfkg=CustomFieldsDraftBuilder.of().type(sdkmf).fields(dkf).build();

        ReviewDraft reviewDraft = ReviewDraft.builder()
                .key(reviewDto.getKey())
                .uniquenessValue(reviewDto.getUniquenessValue())
               // .locale(reviewDto.getLocalizedString())
                .authorName(reviewDto.getAuthorName())
                .title(reviewDto.getTitle())
                .text(reviewDto.getText())
                .target(ResourceIdentifier.productBuilder().id(reviewDto.getId()).build())
                .state(StateResourceIdentifier.builder().key(reviewDto.getStateKey()).build())
                .customer(CustomerResourceIdentifier.builder().id(reviewDto.getCustomerId()).build())
                .rating(reviewDto.getRating())

               /* .custom(CustomFieldsDraft.builder()
                        .type(TypeResourceIdentifier.builder().key("2345").build())
                        .fields(FieldContainer.builder().addValue("no_of_coinsss", 10).build())
                        .build())
*/
//                .custom(CustomFieldsDraft.builder()
//                        .type(typeResourceIdentifierBuilder -> typeResourceIdentifierBuilder.key(reviewDto.getTypeKey()))
//                        .fields(fieldContainerBuilder -> fieldContainerBuilder.addValue(reviewDto.getCustomFieldName(),reviewDto.getCustomFieldValue()))
//                        .build())

                .build();
        return rdp.createReview(reviewDraft);
    }

   /* public State createState(ReviewDto reviewDto)
    {
       StateDraft stateDraft = StateDraft.builder()
               .key(reviewDto.getStateKey())
               .description(LocalizedString.ofEnglish(reviewDto.getStateDescription()))
               .name(LocalizedString.ofEnglish(reviewDto.getStateName()))
               .type(StateTypeEnum.REVIEW_STATE)
               .roles(reviewDto.getStateRoleEnum().)
               .build();

        return rdp.createState(stateDraft);
    }*/


    public Review setTransitionState(ReviewDto reviewDto)
    {
        ReviewUpdate reviewUpdate = ReviewUpdate

                .builder()
                .version(reviewDto.getVersion())
                .actions(ReviewUpdateAction.transitionStateBuilder().state(StateResourceIdentifierBuilder.of().key(reviewDto.getStateKey())
                                .build())
                        .build())
                .build();
        return rdp.setTrasitionState(reviewUpdate, reviewDto.getId());
    }






}
