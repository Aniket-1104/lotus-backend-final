package com.moneview.employeePortal.controller;

import com.moneview.employeePortal.domain.dto.CommunityDto;
import com.moneview.employeePortal.domain.dto.EmployeeDto;
import com.moneview.employeePortal.domain.entities.CommunityEntity;
import com.moneview.employeePortal.domain.entities.EmployeeEntity;
import com.moneview.employeePortal.mappers.Mapper;
import com.moneview.employeePortal.services.CommunityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CommunityController {

    private CommunityService communityService;

    private Mapper<CommunityEntity, CommunityDto> communityMapper;

    public CommunityController(CommunityService communityService, Mapper<CommunityEntity, CommunityDto> communityMapper) {
        this.communityService = communityService;
        this.communityMapper = communityMapper;
    }

    @PostMapping("/communities")
    public CommunityDto createCommunity(@RequestBody CommunityDto communityDto){
        CommunityEntity communityEntity = communityMapper.mapFrom(communityDto);
        CommunityEntity savedCommunityEntity = communityService.createCommunity(communityEntity);
        return communityMapper.mapTo(savedCommunityEntity);
    }

    @GetMapping(path = "/communities")
    public List<CommunityDto> listCommunities(){
        List<CommunityEntity> communities = communityService.findAll();
        return communities.stream()
                .map(communityMapper::mapTo)
                .collect(Collectors.toList());
    }
    @GetMapping("/communities/search/{prefix}")
    public List<CommunityDto> searchCommunity(@PathVariable String prefix) {
        List<CommunityEntity> communities = communityService.getCommunitiesByPrefix(prefix);
        return communities.stream()
                .map(communityMapper::mapTo)
                .collect(Collectors.toList());
    }
}
