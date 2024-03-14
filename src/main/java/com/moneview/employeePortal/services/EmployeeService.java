package com.moneview.employeePortal.services;

import com.moneview.employeePortal.domain.entities.CommunityEntity;
import com.moneview.employeePortal.domain.entities.EmployeeEntity;
import com.moneview.employeePortal.domain.entities.ManagerEntity;
import com.moneview.employeePortal.domain.entities.TagsEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeEntity save(EmployeeEntity employeeEntity);

    List<EmployeeEntity> findAll();

    Optional<EmployeeEntity> findOne(Long empId);

    EmployeeEntity getEmployeeByUsername(String username);

    boolean isExist(Long empId);

    EmployeeEntity partialUpdate(Long empId, EmployeeEntity employeeEntity);

    void delete(Long empId);

    List<EmployeeEntity> getEmployeesByPrefix(String prefix);

    List<EmployeeEntity> findAllEmployeesByManager(Optional<ManagerEntity> managerEntity);

    String generateEmployeesCSV(List<EmployeeEntity> employees);

    List<EmployeeEntity> findEmployeesByCommunity(Optional<CommunityEntity> communityEntity);

    List<EmployeeEntity> findEmployeesByTags(Optional<TagsEntity> tagsEntity);


}
