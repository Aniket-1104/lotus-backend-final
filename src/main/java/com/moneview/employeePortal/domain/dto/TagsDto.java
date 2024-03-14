package com.moneview.employeePortal.domain.dto;

import com.moneview.employeePortal.domain.entities.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagsDto {
    private Long tagId;
    private String tagName;
}
