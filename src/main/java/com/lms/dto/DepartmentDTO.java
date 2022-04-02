package com.lms.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDTO {

    private Long id;
    private String departmentName;

    public DepartmentDTO(Long id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }
}
