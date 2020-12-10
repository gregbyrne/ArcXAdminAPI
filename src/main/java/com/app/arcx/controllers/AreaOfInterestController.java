package com.app.arcx.controllers;

import com.app.arcx.services.AreaOfInterestService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class AreaOfInterestController {

    @Resource
    AreaOfInterestService areaOfInterestService;

    @DeleteMapping("/delete_aoi")
    public void deleteScientistPhoto(int aoi_id)
    {
        areaOfInterestService.deleteAreaOfInterest(aoi_id);
    }

}
