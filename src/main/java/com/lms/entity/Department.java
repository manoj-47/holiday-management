package com.lms.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="department_name")
    private String departmentName;


}
