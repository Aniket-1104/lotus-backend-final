package com.moneview.employeePortal.services;

import com.moneview.employeePortal.domain.entities.CommunityEntity;
import com.moneview.employeePortal.domain.entities.EmployeeEntity;

import java.util.List;
import java.util.Optional;


public interface CommunityService {
    CommunityEntity createCommunity(CommunityEntity communityEntity);

    List<CommunityEntity> findAll();

    List<CommunityEntity> getCommunitiesByPrefix(String prefix);

    Optional<CommunityEntity> findOne(Long communityId);
}
