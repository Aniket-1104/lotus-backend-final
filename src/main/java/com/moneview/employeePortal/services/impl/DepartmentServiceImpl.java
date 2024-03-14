package com.moneview.employeePortal.services.impl;

import com.moneview.employeePortal.domain.entities.DepartmentEntity;
import com.moneview.employeePortal.repositories.DepartmentRepository;
import com.moneview.employeePortal.services.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentEntity createDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    @Override
    public List<DepartmentEntity> findAll() {
        return StreamSupport.stream(departmentRepository.
                                findAll().
                                spliterator(),
                        false)
                .collect(Collectors.toList());
    }
}
