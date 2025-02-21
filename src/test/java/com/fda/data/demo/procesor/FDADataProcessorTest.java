package com.fda.data.demo.procesor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fda.data.demo.gateway.FDARestGateway;
import com.fda.data.demo.repository.ApplicationRepository;
import com.fda.data.demo.Entity.Application;
import com.fda.data.demo.Exception.ApiException;
import com.fda.data.demo.dto.FDAApplicationData;
import com.fda.data.demo.dto.FDAApplicationResponse;
import com.fda.data.demo.dto.Result;
import com.fda.data.demo.processor.FDADataProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class FDADataProcessorTest {

    @Mock
    private FDARestGateway gateway;

    @Mock
    private ApplicationRepository applicationRepo;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ObjectMapper mapper;

    @InjectMocks
    private FDADataProcessor processor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetApplicationDetails_Success() throws Exception, ApiException {
        String name = "testName";
        FDAApplicationResponse response = new FDAApplicationResponse();
        List<Result> results = new ArrayList<>();
        Result result = new Result();
        results.add(result);
        response.setResults(results);

        when(gateway.fetch(name)).thenReturn(response);
        when(modelMapper.map(any(Result.class), eq(FDAApplicationData.class))).thenReturn(new FDAApplicationData());

        List<FDAApplicationData> applicationDetails = processor.getApplicationDetails(name);

        assertNotNull(applicationDetails);
        assertEquals(1, applicationDetails.size());
        verify(gateway, times(1)).fetch(name);
        verify(modelMapper, times(1)).map(any(Result.class), eq(FDAApplicationData.class));
    }

    @Test
    public void testGetApplicationDetails_NoResponse() throws ApiException {
        String name = "testName";

        when(gateway.fetch(name)).thenReturn(null);

        ApiException exception = assertThrows(ApiException.class, () -> {
            processor.getApplicationDetails(name);
        });

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals("No value received from FDA for the given name", exception.getMessage());
        verify(gateway, times(1)).fetch(name);
    }

    @Test
    public void testSaveApplication() throws Exception {
        FDAApplicationData request = new FDAApplicationData();
        Application entity = new Application();

        doReturn(null).when(applicationRepo).save(any(Application.class));
        //doNothing().when(applicationRepo).save(any(Application.class));
        doAnswer(invocation -> {
            Application arg = invocation.getArgument(0);
            arg.setApplicationNumber(request.getApplicationNumber());
            arg.setSponsorName(request.getSponsorName());
            arg.setApplicationJson(mapper.writeValueAsString(request));
            return null;
        }).when(applicationRepo).save(any(Application.class));

        FDAApplicationData savedApplication = processor.saveApplication(request);

        assertNotNull(savedApplication);
        assertEquals(request, savedApplication);
        verify(applicationRepo, times(1)).save(any(Application.class));
    }
}