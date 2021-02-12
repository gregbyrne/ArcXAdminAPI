package com.app.arcx.controllers;

import com.app.arcx.services.AreaOfInterestService;
import com.app.arcx.services.StepsToHelpPrepareService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080", "http://localhost:8082", "http://localhost:7000", "https://arcx-development-admin-ui.devsecops-eval.epa.gov"})
@RestController
@RequestMapping("/api")
public class StepsToHelpController {

    @Resource
    StepsToHelpPrepareService stepsToHelpPrepareService;

    @DeleteMapping("/delete_step")
    public void deleteStep(int step_id)
    {
        stepsToHelpPrepareService.deleteStepToHelpPrepare(step_id);
    }
}
