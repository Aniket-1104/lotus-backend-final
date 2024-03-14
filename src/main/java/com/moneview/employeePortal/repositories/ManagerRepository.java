package com.moneview.employeePortal.repositories;

import com.moneview.employeePortal.domain.entities.ManagerEntity;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository<ManagerEntity, Long> {
}
