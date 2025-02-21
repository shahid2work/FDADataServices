package com.fda.data.demo.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fda.data.demo.Exception.ApiException;
import com.fda.data.demo.dto.FDAApplicationData;
import com.fda.data.demo.processor.FDADataProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.List;

@WebMvcTest(FDADataController.class)
public class FDADataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FDADataProcessor fdaDataProcessor;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetApplicatonsbyManufacturerName_Success() throws Exception, ApiException {
        String name = "testName";
        FDAApplicationData applicationData = new FDAApplicationData();
        List<FDAApplicationData> applicationDataList = Collections.singletonList(applicationData);

        when(fdaDataProcessor.getApplicationDetails(name)).thenReturn(applicationDataList);

        mockMvc.perform(get("/api/v1/FDA/application-details")
                        .param("name", name))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$[0]").exists());

        verify(fdaDataProcessor, times(1)).getApplicationDetails(name);
    }

    @Test
    public void testGetApplicatonsbyManufacturerName_BadRequest() throws Exception, ApiException {
        mockMvc.perform(get("/api/v1/FDA/application-details")
                        .param("name", ""))
                .andExpect(status().isBadRequest());

        verify(fdaDataProcessor, never()).getApplicationDetails(anyString());
    }

    @Test
    public void testSaveAppliction_Success() throws Exception {
        FDAApplicationData request = new FDAApplicationData();

        mockMvc.perform(post("/api/v1/FDA/application-details/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());

        verify(fdaDataProcessor, times(1)).saveApplication(any(FDAApplicationData.class));
    }
}