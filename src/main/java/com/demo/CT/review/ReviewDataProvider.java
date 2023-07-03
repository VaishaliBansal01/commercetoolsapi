package com.demo.CT.review;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.review.Review;
import com.commercetools.api.models.review.ReviewDraft;
import com.commercetools.api.models.review.ReviewUpdate;
import com.commercetools.api.models.state.State;
import com.commercetools.api.models.state.StateDraft;
import com.commercetools.api.models.state.StateRoleEnum;
import com.commercetools.api.models.state.StateTypeEnum;
import com.demo.CT.config.CTConfiguration;

import java.util.List;

public class ReviewDataProvider {
    ProjectApiRoot apiRoot= CTConfiguration.createApiClient();


    public Review createReview(ReviewDraft reviewDraft) {
        return apiRoot.reviews().post(reviewDraft).executeBlocking().getBody();
    }

    public State createState(StateDraft stateDraft) {
        return apiRoot.states().post(stateDraft).executeBlocking().getBody();
    }


    public Review setTrasitionState(ReviewUpdate reviewUpdate, String id ) {
        return apiRoot.reviews().withId(id).post(reviewUpdate).executeBlocking().getBody();
    }
}
