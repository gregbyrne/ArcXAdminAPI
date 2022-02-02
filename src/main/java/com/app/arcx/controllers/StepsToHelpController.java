package com.app.arcx.controllers;

import com.app.arcx.domain.AreaOfInterest;
import com.app.arcx.domain.StepsToHelpPrepare;
import com.app.arcx.repository.AreaOfInterestRepository;
import com.app.arcx.repository.StepsToHelpPrepareRepository;
import com.app.arcx.services.AreaOfInterestService;
import com.app.arcx.services.StepsToHelpPrepareService;
import com.app.arcx.services.UsernameCheckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080", "http://localhost:8082", "http://localhost:7000", "https://arcx-development-admin-ui.devsecops-eval.epa.gov"})
@RestController
@RequestMapping("/api")
public class StepsToHelpController {

    @Resource
    StepsToHelpPrepareService stepsToHelpPrepareService;

    public boolean userVerified = false;

    private UsernameCheckService usernameCheckService = new UsernameCheckService();

    private final StepsToHelpPrepareRepository repository;

    public StepsToHelpController(StepsToHelpPrepareRepository repository) {
        this.repository = repository;
    }

    @DeleteMapping("/delete_step")
    public void deleteStep(int step_id)
    {
        stepsToHelpPrepareService.deleteStepToHelpPrepare(step_id);
    }

    @DeleteMapping("/delete_step_item")
    public void deleteStepItem(int step_item_id)
    {
        stepsToHelpPrepareService.deleteStepToHelpPrepareItem(step_item_id);
    }

    @CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
    @GetMapping("/steps_to_help_prepare")
    public List<StepsToHelpPrepare> getSTHP(@RequestHeader String userid) {

        List<StepsToHelpPrepare> response = null;

        userVerified = usernameCheckService.userCheck(userid);

        if(userVerified){
            response = repository.findAll();
        }
        return response;
    }

    @CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
    @PostMapping("/steps_to_help_prepare")
    public ResponseEntity<String> postSTHP(@RequestHeader String userid, @RequestBody StepsToHelpPrepare stepBody) {

        userVerified = usernameCheckService.userCheck(userid);
        HttpStatus status = null;
        String response = "";

        if(userVerified){

            StepsToHelpPrepare newStep = new StepsToHelpPrepare();
            newStep.name = stepBody.name;
            repository.save(newStep);
            response = "User Verified";
            status = HttpStatus.CREATED;

        }else{
            status = HttpStatus.UNAUTHORIZED;
            response = "Post Failed";
        }

        return new ResponseEntity<String>(response, status);

    }

    @CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
    @PutMapping("/steps_to_help_prepare/")
    public ResponseEntity<String> putSTHP(@RequestHeader String userid, @RequestBody StepsToHelpPrepare Stepbody ) {

        userVerified = usernameCheckService.userCheck(userid);
        HttpStatus status = null;
        String response = "";

        if(userVerified){

            repository.save(Stepbody);
            response = "User Verified";
            status = HttpStatus.OK;

        }else{
            status = HttpStatus.UNAUTHORIZED;
            response = "Post Failed";
        }

        return new ResponseEntity<String>(response, status);

    }

}
