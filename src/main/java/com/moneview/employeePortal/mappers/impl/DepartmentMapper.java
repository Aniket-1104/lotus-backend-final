package com.moneview.employeePortal.mappers.impl;

import com.moneview.employeePortal.domain.dto.DepartmentDto;
import com.moneview.employeePortal.domain.entities.DepartmentEntity;
import com.moneview.employeePortal.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper implements Mapper<DepartmentEntity, DepartmentDto> {
    private ModelMapper modelMapper;

    public DepartmentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public DepartmentDto mapTo(DepartmentEntity departmentEntity) {
        return modelMapper.map(departmentEntity, DepartmentDto.class);
    }

    @Override
    public DepartmentEntity mapFrom(DepartmentDto departmentDto) {
        return modelMapper.map(departmentDto, DepartmentEntity.class);
    }
}
