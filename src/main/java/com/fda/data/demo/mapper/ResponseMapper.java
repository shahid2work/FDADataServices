package com.fda.data.demo.mapper;

import com.fda.data.demo.dto.FDAApplicationData;
import com.fda.data.demo.dto.Result;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class ResponseMapper {

    public void mapFDAApplicationResponse(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<Result, FDAApplicationData>() {
            @Override
            protected void configure() {

            }
        });
    }

}
