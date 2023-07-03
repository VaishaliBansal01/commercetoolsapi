package com.demo.CT.review;

import com.commercetools.api.models.review.Review;
import com.commercetools.api.models.state.State;
import com.commercetools.api.models.type.FieldDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    @Autowired
    ReviewService rs;
    @PostMapping("/reviews")
    public Review createReview(@RequestBody ReviewDto reviewDto)
    {

        return rs.createReview(reviewDto);
    }
    /* @PostMapping("/create-state")
    public State createState(@RequestBody ReviewDto reviewDto)
    {
      return rs.createState(reviewDto);
    }*/
    @PostMapping("/transition-state/{id}")
    public Review setTransitionState(@RequestBody ReviewDto reviewDto, @PathVariable String id)
    {
       return rs.setTransitionState(reviewDto);
    }

}
