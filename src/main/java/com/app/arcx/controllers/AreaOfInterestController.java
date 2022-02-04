package com.app.arcx.controllers;

import com.app.arcx.aspect.LoggingAspect;
import com.app.arcx.domain.AreaOfInterest;
import com.app.arcx.repository.AreaOfInterestRepository;
import com.app.arcx.services.AreaOfInterestService;
import com.app.arcx.services.UsernameCheckService;
import io.swagger.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.awt.geom.Area;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
@RestController
@RequestMapping("/api")
public class AreaOfInterestController {

    @Resource
    AreaOfInterestService areaOfInterestService;

    private final AreaOfInterestRepository repository;

    private UsernameCheckService usernameCheckService = new UsernameCheckService();

    public boolean userVerified = false;

    public AreaOfInterestController(AreaOfInterestRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
    @DeleteMapping("/delete_item")
    public ResponseEntity<String> deleteItem(@RequestHeader String userid, @RequestParam int item_id) {

        userVerified = usernameCheckService.userCheck(userid);
        HttpStatus status = null;
        String response = "";


        if(userVerified){
            areaOfInterestService.deleteAreaOfInterestItem(item_id);

            response = "User Verified and Delete Successful.";
            status = HttpStatus.OK;

        }else{
            status = HttpStatus.UNAUTHORIZED;
            response = "Delete Failed";
        }

        return new ResponseEntity<String>(response, status);
    }

    @CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
    @GetMapping("/area_of_interest")
    public List<AreaOfInterest> getAOI(@RequestHeader String userid) {

        List<AreaOfInterest> response = null;

        userVerified = usernameCheckService.userCheck(userid);

        if(userVerified){
            response = repository.findAll();
            }
        return response;
    }

    @CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
    @PostMapping("/area_of_interest")
    public ResponseEntity<String> postAOI(@RequestHeader String userid, @RequestBody AreaOfInterest aoibody) {

        userVerified = usernameCheckService.userCheck(userid);
        HttpStatus status = null;
        String response = "";

        if(userVerified){

            List<AreaOfInterest> tocount = repository.findAll();
            AreaOfInterest aoi = new AreaOfInterest();
            aoi.setPosition(tocount.size());
            aoi.name = aoibody.name;
            repository.save(aoi);
            response = "User Verified";
            status = HttpStatus.OK;

        }else{
            status = HttpStatus.UNAUTHORIZED;
            response = "Post Failed";
        }

        return new ResponseEntity<String>(response, status);

    }

    @CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
    @DeleteMapping("/delete_aoi")
    public ResponseEntity<String> deleteAOI(@RequestHeader String userid, @RequestParam int aoi_id) {

        userVerified = usernameCheckService.userCheck(userid);
        HttpStatus status = null;
        String response = "";


        if(userVerified){
            areaOfInterestService.deleteAreaOfInterest(aoi_id);

            response = "User Verified and Delete Successful.";
            status = HttpStatus.OK;

        }else{
            status = HttpStatus.UNAUTHORIZED;
            response = "Delete Failed";
        }

        return new ResponseEntity<String>(response, status);
    }

    @CrossOrigin(origins = {"http://localhost:8080", "https://climateadaptationadminstg.epa.gov"})
    @PutMapping("/area_of_interest")
    public ResponseEntity<String> putAOI(@RequestHeader String userid, @RequestBody AreaOfInterest aoibody ) {

        userVerified = usernameCheckService.userCheck(userid);
        HttpStatus status = null;
        String response = "";

        if(userVerified){

            repository.save(aoibody);
            response = "User Verified";
            status = HttpStatus.OK;

        }else{
            status = HttpStatus.UNAUTHORIZED;
            response = "Post Failed";
        }

        return new ResponseEntity<String>(response, status);

    }


}
