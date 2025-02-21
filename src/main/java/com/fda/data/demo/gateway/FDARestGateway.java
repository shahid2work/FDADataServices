package com.fda.data.demo.gateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fda.data.demo.Exception.ApiException;
import com.fda.data.demo.dto.FDAApplicationResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class FDARestGateway {
    private static final Logger logger = LogManager.getLogger(FDARestGateway.class);

    @Value("${fda.service.url}")
    private String reqUrl;

    public FDAApplicationResponse fetch(String name) throws ApiException {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =null;
        FDAApplicationResponse result = null;
        String resourceUrl
                = reqUrl+"?search="+name;
       try {
           response = restTemplate.getForEntity(resourceUrl , String.class);
           if(response!=null) {
               if(response.getBody()!=null) {
                   logger.info("Response from FDA Service:: " + response.getBody().toString());
                   ObjectMapper responseObj = new ObjectMapper();
                   result = responseObj.readValue(response.getBody().toString(),FDAApplicationResponse.class);
               }else{
                   logger.info("Received invalid response from FDA Service"+response.toString());
               }
           }
       }
       catch(HttpClientErrorException httpEx){
           logger.error("FDARestGateway : fetch failed with status: "+httpEx.getStatusCode());
           throw  new ApiException((HttpStatus) httpEx.getStatusCode(),httpEx.getMessage());
       }
       catch(JsonProcessingException parseException){
           logger.error("FDARestGateway : fetch failed while parsing response : "+parseException.getMessage());
           result=null;
       }
       catch(Exception e){
           logger.error("FDARestGateway : fetch failed with status: "+e.getMessage());
           e.printStackTrace();
           throw e;
       }
       return result;
    }

}
