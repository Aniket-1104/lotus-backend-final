package com.moneview.employeePortal.services;

import com.moneview.employeePortal.domain.entities.EmployeeEntity;
import com.moneview.employeePortal.domain.entities.ManagerEntity;

import java.util.List;
import java.util.Optional;

public interface ManagerService {
    ManagerEntity createManager(Long managerId, ManagerEntity managerEntity);

    List<ManagerEntity> findAll();

    boolean isExist(Long managerId);

    Optional<ManagerEntity> findOne(Long managerId);
}
