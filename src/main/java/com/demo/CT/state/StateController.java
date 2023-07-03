package com.demo.CT.state;

import com.commercetools.api.models.state.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {
    @Autowired
    StateService stateService;
    @PostMapping("/state")
    public State createState(@RequestBody StateDTO stateDTO)
    {
        return stateService.createState(stateDTO);
    }
}
