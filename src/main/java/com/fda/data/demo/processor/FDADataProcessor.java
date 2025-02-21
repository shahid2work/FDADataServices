package com.fda.data.demo.processor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fda.data.demo.Entity.Application;
import com.fda.data.demo.Exception.ApiException;
import com.fda.data.demo.dto.FDAApplicationData;
import com.fda.data.demo.dto.FDAApplicationResponse;
import com.fda.data.demo.dto.Product;
import com.fda.data.demo.dto.Result;
import com.fda.data.demo.gateway.FDARestGateway;
import com.fda.data.demo.repository.ApplicationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FDADataProcessor {
    private static final Logger logger = LogManager.getLogger(FDADataProcessor.class);

    @Autowired
    FDARestGateway gateway;

    @Autowired
    ApplicationRepository applicationRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ObjectMapper mapper;

    public List<FDAApplicationData> getApplicationDetails(String name) throws ApiException {
    logger.info("FDADataProcessor Enter");
        FDAApplicationResponse response = null;
        List<FDAApplicationData> lstApplicationData = new ArrayList<FDAApplicationData>();
        response =  gateway.fetch(name);
        if(null!=response) {
            logger.info("FDADataProcessor response is not null");
            for(Result iter : response.getResults()){
                FDAApplicationData applicationData = modelMapper.map(iter,FDAApplicationData.class);
                lstApplicationData.add(applicationData);
            }
            return lstApplicationData;
        }else throw new ApiException(HttpStatus.NOT_FOUND,"No value received from FDA for the given name");
    }

    public FDAApplicationData saveApplication(FDAApplicationData request){

        FDAApplicationData responseDto = new FDAApplicationData();
        Application entity = new Application();
        populateEntity(entity,request);
        applicationRepo.save(entity);
        return request;

    }

    private void populateEntity(Application entity,FDAApplicationData request){
        try {
            entity.setApplicationNumber(request.getApplicationNumber());
            entity.setSponsorName(request.getSponsorName());
            entity.setApplicationJson(mapper.writeValueAsString(request));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
