package com.moneview.employeePortal.repositories;

import com.moneview.employeePortal.domain.entities.CommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommunityRepository extends CrudRepository<CommunityEntity, Long>, JpaRepository<CommunityEntity,Long> {
    List<CommunityEntity> findByCommunityNameStartingWith(String prefix);
}
