package com.moneview.employeePortal.services;

import com.moneview.employeePortal.domain.entities.DepartmentEntity;

import java.util.List;

public interface DepartmentService {
    DepartmentEntity createDepartment(DepartmentEntity departmentEntity);

    List<DepartmentEntity> findAll();
}
