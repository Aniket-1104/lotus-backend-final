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
public class CommunityDto {
    private Long communityId;
    private String communityName;
    private String description;
}
