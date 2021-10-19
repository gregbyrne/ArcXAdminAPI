package com.app.arcx.controllers;

import com.app.arcx.services.AreaOfInterestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080", "http://localhost:8082", "http://localhost:7000", "https://arcx-development-admin-ui.devsecops-eval.epa.gov", "https://arcx-admin-ui-stg.devsecops-eval.epa.gov"})
@RestController
@RequestMapping("/api")
public class AreaOfInterestController {

    @Resource
    AreaOfInterestService areaOfInterestService;

    @DeleteMapping("/delete_aoi")
    public void deleteAreaOfInterest(int aoi_id)
    {
        areaOfInterestService.deleteAreaOfInterest(aoi_id);
    }

    @DeleteMapping("/delete_item")
    public void deleteItem(int item_id)
    {
        areaOfInterestService.deleteAreaOfInterestItem(item_id);
    }

}
