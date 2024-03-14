package com.moneview.employeePortal.services.impl;

import com.moneview.employeePortal.domain.entities.CommunityEntity;
import com.moneview.employeePortal.repositories.CommunityRepository;
import com.moneview.employeePortal.services.CommunityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CommunityServiceImpl implements CommunityService {

    private CommunityRepository communityRepository;

    public CommunityServiceImpl(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @Override
    public CommunityEntity createCommunity(CommunityEntity communityEntity) {
        return communityRepository.save(communityEntity);
    }

    @Override
    public List<CommunityEntity> findAll() {
        return StreamSupport.stream(communityRepository.
                                findAll().
                                spliterator(),
                        false)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommunityEntity> getCommunitiesByPrefix(String prefix) {
        return StreamSupport.stream(communityRepository.
                                findByCommunityNameStartingWith(prefix).
                                spliterator(),
                        false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CommunityEntity> findOne(Long communityId) {
        return communityRepository.findById(communityId);
    }


}
