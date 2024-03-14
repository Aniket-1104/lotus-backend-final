package com.moneview.employeePortal.mappers.impl;

import com.moneview.employeePortal.domain.dto.EmployeeDto;
import com.moneview.employeePortal.domain.entities.EmployeeEntity;
import com.moneview.employeePortal.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper implements Mapper<EmployeeEntity, EmployeeDto> {
    private ModelMapper modelMapper;

    public EmployeeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public EmployeeDto mapTo(EmployeeEntity employeeEntity) {
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    @Override
    public EmployeeEntity mapFrom(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, EmployeeEntity.class);
    }
}
