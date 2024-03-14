package com.moneview.employeePortal.controller;

import com.moneview.employeePortal.domain.entities.EmployeeEntity;
import com.moneview.employeePortal.services.CloudinaryImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class CloudinaryImageUploadController {
    @Autowired
    public CloudinaryImageService cloudinaryImageService;

    @PostMapping("/upload/{empId}")
    public ResponseEntity<Map> uploadImage(@RequestParam("image") MultipartFile file, @PathVariable("empId") Long empId){
        Map data = cloudinaryImageService.upload(file, empId);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
