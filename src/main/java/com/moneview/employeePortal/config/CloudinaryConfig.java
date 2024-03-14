package com.moneview.employeePortal.config;

import com.cloudinary.Cloudinary;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    @Bean
    public Cloudinary getCloudinary(){
        Map config = new HashMap();
        config.put("cloud_name", "djt3bitue");
        config.put("api_key", "752758181136338");
        config.put("api_secret", "vwOXNpm4qixtosM8LtdJ3WMk94Y");
        config.put("secure", true);
        return new Cloudinary(config);
    }

}
