package com.moneview.employeePortal.controller;

import com.moneview.employeePortal.domain.dto.DepartmentDto;
import com.moneview.employeePortal.domain.entities.DepartmentEntity;
import com.moneview.employeePortal.mappers.Mapper;
import com.moneview.employeePortal.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    private Mapper<DepartmentEntity, DepartmentDto> departmentMapper;

    public DepartmentController(DepartmentService departmentService, Mapper<DepartmentEntity, DepartmentDto> departmentMapper) {
        this.departmentService = departmentService;
        this.departmentMapper = departmentMapper;
    }

    @PostMapping(path = "/departments")
    public DepartmentDto createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentEntity departmentEntity = departmentMapper.mapFrom(departmentDto);
        DepartmentEntity savedDepartmentEntity = departmentService.createDepartment(departmentEntity);
        return departmentMapper.mapTo(savedDepartmentEntity);
    }

    @GetMapping(path = "/departments")
    public List<DepartmentDto> listDepartments(){
        List<DepartmentEntity> departments = departmentService.findAll();
        return departments.stream()
                .map(departmentMapper::mapTo)
                .collect(Collectors.toList());
    }
}
