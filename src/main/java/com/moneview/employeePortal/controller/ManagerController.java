package com.moneview.employeePortal.controller;

import com.moneview.employeePortal.domain.dto.EmployeeDto;
import com.moneview.employeePortal.domain.dto.ManagerDto;
import com.moneview.employeePortal.domain.entities.EmployeeEntity;
import com.moneview.employeePortal.domain.entities.ManagerEntity;
import com.moneview.employeePortal.mappers.Mapper;
import com.moneview.employeePortal.services.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ManagerController {
    private Mapper<ManagerEntity, ManagerDto> managerMapper;

    private ManagerService managerService;

    public ManagerController(Mapper<ManagerEntity, ManagerDto> managerMapper, ManagerService managerService) {
        this.managerMapper = managerMapper;
        this.managerService = managerService;
    }

    @PutMapping(path = "/manager/{managerId}")
    public ResponseEntity<ManagerDto> createManager(
            @PathVariable("manageId") Long managerId,
            @RequestBody ManagerDto managerDto){
        ManagerEntity managerEntity = managerMapper.mapFrom(managerDto);
        ManagerEntity savedManagerEntity = managerService.createManager(managerId, managerEntity);
        ManagerDto savedManagerDto = managerMapper.mapTo(savedManagerEntity);
        return new ResponseEntity<>(savedManagerDto, HttpStatus.CREATED);
    }

    @GetMapping(path = "/manager")
    public List<ManagerDto> listManagers(){
        List<ManagerEntity> managers = managerService.findAll();
        return managers.stream()
                .map(managerMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/manager/{managerId}")
    public ResponseEntity<ManagerDto> getManager(@PathVariable("managerId") Long managerId){
        Optional<ManagerEntity> foundManager = managerService.findOne(managerId);
        return foundManager.map(managerEntity -> {
            ManagerDto managerDto = managerMapper.mapTo(managerEntity);
            return new ResponseEntity<>(managerDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
