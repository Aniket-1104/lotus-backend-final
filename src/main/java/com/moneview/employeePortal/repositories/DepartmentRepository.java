package com.moneview.employeePortal.repositories;

import com.moneview.employeePortal.domain.entities.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Long> {
}
