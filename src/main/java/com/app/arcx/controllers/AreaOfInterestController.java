package com.app.arcx.controllers;

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
import java.util.List;

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


    @DeleteMapping("/delete_aoi")
    public ResponseEntity<String> deleteAreaOfInterest(@RequestHeader("userid") String language, int aoi_id)
    {
        //areaOfInterestService.deleteAreaOfInterest(aoi_id);
        String greeting = "GreetingSTring " + aoi_id;

        return new ResponseEntity<String>(greeting, HttpStatus.OK);
    }

    @DeleteMapping("/delete_item")
    public void deleteItem(int item_id)
    {
        areaOfInterestService.deleteAreaOfInterestItem(item_id);
    }

    @GetMapping("/area_of_interest")
    public List<AreaOfInterest> getAOI(HttpServletRequest request,
                                           UriComponentsBuilder uriComponentsBuilder) {

        List<AreaOfInterest> response = null;

        userVerified = usernameCheckService.userCheck(request);

            if(userVerified){
                response = repository.findAll();
            }
        //return new ResponseEntity<String>(LanguageResponse, HttpStatus.OK);
        return response;
    }

    @PostMapping("/multiValue")
    public ResponseEntity<String> postAOI(HttpServletRequest request,
                                       UriComponentsBuilder uriComponentsBuilder) {

        userVerified = usernameCheckService.userCheck(request);
        HttpStatus status = null;
        String response = "";

        if(userVerified){

            var name = request.getParameter("name");
            AreaOfInterest aoi = new AreaOfInterest();
            aoi.name = name;
            repository.save(aoi);
            response = "User Verified";
            status = HttpStatus.OK;

        }else{
            status = HttpStatus.UNAUTHORIZED;
            response = "Post Failed";
        }

        return new ResponseEntity<String>(response, status);

    }

    @DeleteMapping("/multiValue")
    public ResponseEntity<String> deleteAOI(HttpServletRequest request,
                                       UriComponentsBuilder uriComponentsBuilder) {

        userVerified = usernameCheckService.userCheck(request);
        HttpStatus status = null;
        String response = "";

        if(userVerified){
            String itemid = request.getParameter("itemid");
            repository.deleteById(Integer.parseInt(itemid));

            response = "User Verified and Delete Successful.";
            status = HttpStatus.OK;

        }else{
            status = HttpStatus.UNAUTHORIZED;
            response = "Delete Failed";
        }

        return new ResponseEntity<String>(response, status);
    }


    @PutMapping("/multiValue")
    public ResponseEntity<String> putAOI(HttpServletRequest request,
                                       UriComponentsBuilder uriComponentsBuilder) {

        userVerified = usernameCheckService.userCheck(request);
        HttpStatus status = null;
        String response = "";

        if(userVerified){

            var name = request.getParameter("name");
            int id = Integer.parseInt(request.getParameter("id"));
            int position = Integer.parseInt(request.getParameter("position"));
            AreaOfInterest aoi = new AreaOfInterest();
            aoi.name = name;
            aoi.id = id;
            aoi.position = position;

            repository.save(aoi);
            response = "User Verified";
            status = HttpStatus.OK;

        }else{
            status = HttpStatus.UNAUTHORIZED;
            response = "Post Failed";
        }

        return new ResponseEntity<String>(response, status);

    }


}
