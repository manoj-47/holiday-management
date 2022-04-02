package com.lms.controller;

import com.lms.dto.DepartmentDTO;
import com.lms.entity.Department;
import com.lms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(departmentService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Long departmentId){
        DepartmentDTO departmentDTO = departmentService.get(departmentId);
        if(departmentDTO != null)
            return new ResponseEntity<>(departmentDTO,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody DepartmentDTO departmentDTO){
        return new ResponseEntity<>(departmentService.save(departmentDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long departmentId){
        departmentService.delete(departmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
