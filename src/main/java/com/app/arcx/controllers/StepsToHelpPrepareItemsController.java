package com.app.arcx.controllers;

import com.app.arcx.domain.StepsToHelpPrepareItems;
import com.app.arcx.repository.StepsToHelpPrepareItemsRepository;
import com.app.arcx.services.UsernameCheckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
@RestController
@RequestMapping("/api")
public class StepsToHelpPrepareItemsController {


    private UsernameCheckService usernameCheckService = new UsernameCheckService();

    public boolean userVerified = false;

    private final StepsToHelpPrepareItemsRepository repository;

    public StepsToHelpPrepareItemsController(StepsToHelpPrepareItemsRepository repository) {
        this.repository = repository;
    }


    @CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
    @GetMapping("/steps_to_help_prepare_items")
    public List<StepsToHelpPrepareItems> getStepsItems(@RequestHeader String userid) {

        List<StepsToHelpPrepareItems> response = null;

        userVerified = usernameCheckService.userCheck(userid);

        if(userVerified){
            response = repository.findAll();
        }
        return response;
    }

    @CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
    @PostMapping("/steps_to_help_prepare_items")
    public ResponseEntity<String> postStepsItems(@RequestHeader String userid, @RequestBody StepsToHelpPrepareItems STHPItem) {

        userVerified = usernameCheckService.userCheck(userid);
        HttpStatus status = null;
        String response = "";

        if(userVerified){

            StepsToHelpPrepareItems item = new StepsToHelpPrepareItems();
            item.setParentid(STHPItem.getParentid());
            item.name = STHPItem.name;
            repository.save(item);
            response = "User Verified";
            status = HttpStatus.CREATED;

        }else{
            status = HttpStatus.UNAUTHORIZED;
            response = "Post Failed";
        }

        return new ResponseEntity<String>(response, status);

    }

    @CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
    @DeleteMapping("/steps_to_help_prepare_items/{step_id}")
    public ResponseEntity<String> deleteStepsItems(@RequestHeader String userid, @RequestParam int aoi_id) {

        userVerified = usernameCheckService.userCheck(userid);
        HttpStatus status = null;
        String response = "";


        if(userVerified){
            repository.deleteById(aoi_id);

            response = "User Verified and Delete Successful.";
            status = HttpStatus.OK;

        }else{
            status = HttpStatus.UNAUTHORIZED;
            response = "Delete Failed";
        }

        return new ResponseEntity<String>(response, status);
    }

    @CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
    @PutMapping("/steps_to_help_prepare_items")
    public ResponseEntity<String> putStepsItems(@RequestHeader String userid, @RequestBody StepsToHelpPrepareItems STHPITEMbody ) {

        userVerified = usernameCheckService.userCheck(userid);
        HttpStatus status = null;
        String response = "";

        if(userVerified){

            repository.save(STHPITEMbody);
            response = "User Verified";
            status = HttpStatus.OK;

        }else{
            status = HttpStatus.UNAUTHORIZED;
            response = "Post Failed";
        }

        return new ResponseEntity<String>(response, status);

    }


}
