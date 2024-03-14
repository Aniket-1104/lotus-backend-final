package com.moneview.employeePortal.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "manager")
public class ManagerEntity {
    @Id
    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "manager_name")
    private String managerName;
}
