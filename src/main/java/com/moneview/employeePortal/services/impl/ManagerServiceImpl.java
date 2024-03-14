package com.moneview.employeePortal.services.impl;

import com.moneview.employeePortal.domain.entities.ManagerEntity;
import com.moneview.employeePortal.repositories.ManagerRepository;
import com.moneview.employeePortal.services.ManagerService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ManagerServiceImpl implements ManagerService {
    private ManagerRepository managerRepository;
    private ManagerService managerService;

    public ManagerServiceImpl(@Lazy ManagerRepository managerRepository, @Lazy ManagerService managerService) {
        this.managerRepository = managerRepository;
        this.managerService = managerService;
    }

    @Override
    public ManagerEntity createManager(Long managerId, ManagerEntity managerEntity) {
        managerEntity.setManagerId(managerId);
        return managerRepository.save(managerEntity);
    }

    @Override
    public List<ManagerEntity> findAll() {
        return StreamSupport.stream(managerRepository.
                                findAll().
                                spliterator(),
                        false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isExist(Long managerId) {
        return managerRepository.existsById(managerId);
    }

    @Override
    public Optional<ManagerEntity> findOne(Long managerId) {
        return managerRepository.findById(managerId);
    }
}
