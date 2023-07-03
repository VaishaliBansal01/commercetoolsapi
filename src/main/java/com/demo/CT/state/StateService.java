package com.demo.CT.state;

import com.commercetools.api.models.state.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {
    @Autowired
    StateRepository stateRepository;

    public State createState(StateDTO stateDTO)
    {
        StateDraft stateDraft = StateDraft.builder()
                .key(stateDTO.getKey())

                .type(stateDTO.getType())
//                .roles(StateRoleEnum.REVIEW_INCLUDED_IN_STATISTICS)
                .initial(stateDTO.getInitial())
                .transitions(StateResourceIdentifier.builder().key(stateDTO.getTransitionKey()).build())
                .build();
        return stateRepository.createState(stateDraft);

    }
}
