package com.lms.service;

import com.lms.dto.DepartmentDTO;
import com.lms.entity.Department;
import com.lms.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<DepartmentDTO> findAll() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOs = departments.stream().map(e -> new DepartmentDTO(e.getId(), e.getDepartmentName())).collect(Collectors.toList());
        return departmentDTOs;
    }

    public DepartmentDTO get(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElse(null);
        if (department != null) {
            DepartmentDTO departmentDTO = new DepartmentDTO(department.getId(), department.getDepartmentName());
            return departmentDTO;
        } else {
            return null;
        }
    }

    public DepartmentDTO save(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setDepartmentName(departmentDTO.getDepartmentName());
        departmentRepository.save(department);
        departmentDTO.setId(department.getId());
        return departmentDTO;
    }

    public void delete(Long departmentId) {
        Department department = departmentRepository.getById(departmentId);
        if (department != null)
            departmentRepository.delete(department);
    }
}
