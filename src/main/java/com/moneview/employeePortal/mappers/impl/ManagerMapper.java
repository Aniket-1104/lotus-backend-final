package com.moneview.employeePortal.mappers.impl;

import com.moneview.employeePortal.domain.dto.ManagerDto;
import com.moneview.employeePortal.domain.entities.ManagerEntity;
import com.moneview.employeePortal.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapper implements Mapper<ManagerEntity, ManagerDto> {

    private ModelMapper modelMapper;

    public ManagerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ManagerDto mapTo(ManagerEntity managerEntity) {
        return modelMapper.map(managerEntity, ManagerDto.class);
    }

    @Override
    public ManagerEntity mapFrom(ManagerDto managerDto) {
        return modelMapper.map(managerDto, ManagerEntity.class);
    }
}
