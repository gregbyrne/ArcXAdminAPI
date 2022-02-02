package com.app.arcx.controllers;

import com.app.arcx.domain.AreaOfInterest;
import com.app.arcx.domain.AreaOfInterestItems;
import com.app.arcx.repository.AreaOfInterestItemsRepository;
import com.app.arcx.repository.AreaOfInterestRepository;
import com.app.arcx.services.AreaOfInterestService;
import com.app.arcx.services.UsernameCheckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
@RestController
@RequestMapping("/api")
public class AreaOfInterestItemsController {

    @Resource
    AreaOfInterestService areaOfInterestItemsService;

    private final AreaOfInterestItemsRepository repository;

    private UsernameCheckService usernameCheckService = new UsernameCheckService();

    public boolean userVerified = false;

    public AreaOfInterestItemsController(AreaOfInterestItemsRepository repository) {
        this.repository = repository;
    }


    @CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
    @GetMapping("/area_of_interest_items")
    public List<AreaOfInterestItems> getAOIItems(@RequestHeader String userid) {

        List<AreaOfInterestItems> response = null;

        userVerified = usernameCheckService.userCheck(userid);

        if(userVerified){
            response = repository.findAll();
            }
        return response;
    }

    @CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
    @PostMapping("/area_of_interest_items")
    public ResponseEntity<String> postAOIItems(@RequestHeader String userid, @RequestBody AreaOfInterestItems  itemBody) {

        userVerified = usernameCheckService.userCheck(userid);
        HttpStatus status = null;
        String response = "";

        if(userVerified){

            AreaOfInterestItems item = new AreaOfInterestItems();
            item.name = itemBody.name;
            item.setParentid(itemBody.getParentid());
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
    @PutMapping("/area_of_interest_items")
    public ResponseEntity<String> putAOIItems(@RequestHeader String userid, @RequestBody AreaOfInterestItems itemBody ) {

        userVerified = usernameCheckService.userCheck(userid);
        HttpStatus status = null;
        String response = "";

        if(userVerified){

            repository.save(itemBody);
            response = "User Verified";
            status = HttpStatus.OK;

        }else{
            status = HttpStatus.UNAUTHORIZED;
            response = "Post Failed";
        }

        return new ResponseEntity<String>(response, status);

    }


}
