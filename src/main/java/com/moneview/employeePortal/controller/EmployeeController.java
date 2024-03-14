package com.moneview.employeePortal.controller;

import com.moneview.employeePortal.domain.dto.EmployeeDto;
import com.moneview.employeePortal.domain.entities.CommunityEntity;
import com.moneview.employeePortal.domain.entities.EmployeeEntity;
import com.moneview.employeePortal.domain.entities.ManagerEntity;
import com.moneview.employeePortal.domain.entities.TagsEntity;
import com.moneview.employeePortal.mappers.Mapper;
import com.moneview.employeePortal.services.CommunityService;
import com.moneview.employeePortal.services.EmployeeService;
import com.moneview.employeePortal.services.ManagerService;
import com.moneview.employeePortal.services.TagsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;
    private ManagerService managerService;
    private CommunityService communityService;
    private TagsService tagsService;

    private Mapper<EmployeeEntity, EmployeeDto> employeeMapper;

    public EmployeeController(EmployeeService employeeService, Mapper<EmployeeEntity, EmployeeDto> employeeMapper,  ManagerService managerService, CommunityService communityService, TagsService tagsService) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
        this.managerService = managerService;
        this.communityService = communityService;
        this.tagsService = tagsService;
    }

    @PostMapping(path = "/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeEntity employeeEntity = employeeMapper.mapFrom(employeeDto);
        EmployeeEntity savedEmployeeEntity = employeeService.save(employeeEntity);
        return employeeMapper.mapTo(savedEmployeeEntity);
    }

    @GetMapping(path = "/employees")
    public List<EmployeeEntity> listEmployees(){
        List<EmployeeEntity> employees = employeeService.findAll();
        return employees;
//        return employees.stream()
//                .map(employeeMapper::mapTo)
//                .collect(Collectors.toList());
    }

    @GetMapping(path = "/employees/id/{empId}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("empId") Long empId){
        Optional<EmployeeEntity> foundEmployee = employeeService.findOne(empId);
        return foundEmployee.map(employeeEntity -> {
            EmployeeDto employeeDto = employeeMapper.mapTo(employeeEntity);
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/employees/username/{username}")
    public ResponseEntity<EmployeeDto> getEmployeeByUsername(@PathVariable("username") String username){
        EmployeeEntity foundEmployee = employeeService.getEmployeeByUsername(username);
        EmployeeDto employeeDto = employeeMapper.mapTo(foundEmployee);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @PutMapping(path = "/employees/{empId}")
    public ResponseEntity<EmployeeDto> fullUpdateEmployee(
            @PathVariable("empId") Long empId,
            @RequestBody EmployeeDto employeeDto){
        if(!employeeService.isExist(empId)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeDto.setEmpId(empId);
        EmployeeEntity employeeEntity = employeeMapper.mapFrom(employeeDto);
        EmployeeEntity savedEmployeeEntity = employeeService.save(employeeEntity);
        return new ResponseEntity<>(
                employeeMapper.mapTo(savedEmployeeEntity),
                HttpStatus.OK);
    }

    @PatchMapping(path = "/employees/{empId}")
    public ResponseEntity<EmployeeDto> partialUpdate(
            @PathVariable("empId") Long empId,
            @RequestBody EmployeeDto employeeDto){
        if(!employeeService.isExist(empId)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        EmployeeEntity employeeEntity = employeeMapper.mapFrom(employeeDto);
        EmployeeEntity updatedEmployee = employeeService.partialUpdate(empId, employeeEntity);
        return new ResponseEntity<>(
                employeeMapper.mapTo(updatedEmployee),
                HttpStatus.OK);
    }

    @DeleteMapping(path = "/employees/{empId}")
    public ResponseEntity deleteEmployee(@PathVariable("empId") Long empId){
        employeeService.delete(empId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employees/search/{prefix}")
    public List<EmployeeDto> searchEmployee(@PathVariable String prefix) {
        List<EmployeeEntity> employees = employeeService.getEmployeesByPrefix(prefix);
        return employees.stream()
                .map(employeeMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping("/byManager/{managerId}")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByManager(@PathVariable Long managerId) {
        Optional<ManagerEntity> managerEntity = managerService.findOne(managerId);
        if (managerEntity.isPresent()) {
            List<EmployeeEntity> employees = employeeService.findAllEmployeesByManager(managerEntity);
            List<EmployeeDto> savedEmployees = employees.stream()
                    .map(employeeMapper::mapTo)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(savedEmployees, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byCommunity/{communityId}")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByCommunity(@PathVariable Long communityId) {
        Optional<CommunityEntity> communityEntity = communityService.findOne(communityId);

        if (communityEntity.isPresent()) {
            List<EmployeeEntity> employees = employeeService.findEmployeesByCommunity(communityEntity);
            List<EmployeeDto> savedEmployees = employees.stream()
                    .map(employeeMapper::mapTo)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(savedEmployees, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/csv/{managerId}")
    public ResponseEntity<String> getCsvFile(@PathVariable("managerId") Long managerId) {
        Optional<ManagerEntity> managerEntity = managerService.findOne(managerId);

        if (managerEntity.isPresent()) {
            List<EmployeeEntity> employees = employeeService.findAllEmployeesByManager(managerEntity);

            String filePath = employeeService.generateEmployeesCSV(employees);
            return new ResponseEntity<>(filePath, HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Manager not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byTags/{tagId}")
    public ResponseEntity<List<EmployeeEntity>> getEmployeesByTags(@PathVariable Long tagId) {
        Optional<TagsEntity> tagsEntity = tagsService.findOne(tagId);

        if (tagsEntity.isPresent()) {
            List<EmployeeEntity> employees = employeeService.findEmployeesByTags(tagsEntity);
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
