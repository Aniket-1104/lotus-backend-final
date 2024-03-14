package com.moneview.employeePortal.services.impl;

import com.cloudinary.Cloudinary;
import com.moneview.employeePortal.domain.entities.EmployeeEntity;
import com.moneview.employeePortal.repositories.EmployeeRepository;
import com.moneview.employeePortal.services.CloudinaryImageService;
import com.moneview.employeePortal.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class CloudinaryImageServiceImpl implements CloudinaryImageService {
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Map upload(MultipartFile file, Long empId) {
        try {
            Map data = cloudinary.uploader().upload(file.getBytes(), Map.of());
            String photoUrl = (String) data.get("url");

            EmployeeEntity employee = employeeRepository.findById(empId).orElse(null);
            if (employee != null) {
                employee.setPersonalPhotoLink(photoUrl);
                employeeRepository.save(employee);
            }

            return data;
        } catch (IOException e) {
            throw new RuntimeException("Image uploading fail !!");
        }
    }
}
