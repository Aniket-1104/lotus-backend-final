package com.moneview.employeePortal.mappers.impl;

import com.moneview.employeePortal.domain.dto.CommunityDto;
import com.moneview.employeePortal.domain.entities.CommunityEntity;
import com.moneview.employeePortal.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CommunityMapper implements Mapper<CommunityEntity, CommunityDto> {
    private ModelMapper modelMapper;

    public CommunityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CommunityDto mapTo(CommunityEntity communityEntity) {
        return modelMapper.map(communityEntity, CommunityDto.class);
    }

    @Override
    public CommunityEntity mapFrom(CommunityDto communityDto) {
        return modelMapper.map(communityDto, CommunityEntity.class);
    }
}
