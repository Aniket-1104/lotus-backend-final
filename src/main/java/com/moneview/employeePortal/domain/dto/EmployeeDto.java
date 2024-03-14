package com.moneview.employeePortal.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    private Long empId;
    private String name;
    private String dob;
    private String designation;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private String slackUrl;
    private String personalPhotoLink;
    private String officePhotoLink;
    private ManagerDto managerDto;
    private DepartmentDto departmentDto;
    private Set<CommunityDto> communityDto;
    private Set<TagsDto> tags;
}
