package com.fda.data.demo.controller;

import com.fda.data.demo.Exception.ApiException;
import com.fda.data.demo.dto.FDAApplicationData;
import com.fda.data.demo.processor.FDADataProcessor;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/FDA")
public class FDADataController {
    private static final Logger logger = LogManager.getLogger(FDADataProcessor.class);

    @Autowired
    FDADataProcessor fdaDataProcessor;
    @GetMapping("/application-details")
    public ResponseEntity<List<FDAApplicationData>> getApplicatonsbyManufacturerName(@RequestParam String name) throws ApiException {
        logger.info("FDADataService getByManufacturer invoked:: "+name);
        List<FDAApplicationData> response=null;
        if(StringUtils.isNotBlank(name)){
            response=fdaDataProcessor.getApplicationDetails(name);
        }else{
            ApiException validationException = new ApiException(HttpStatus.BAD_REQUEST,"Manufacturer name cannot be null");
            ResponseEntity responseEntity = new ResponseEntity<>(validationException, new HttpHeaders(),validationException.getStatus());
            return responseEntity;
        }

        return new ResponseEntity<>(response,new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/application-details/save")
    public ResponseEntity<FDAApplicationData> saveAppliction(@RequestBody FDAApplicationData request){

        fdaDataProcessor.saveApplication(request);

        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

}
