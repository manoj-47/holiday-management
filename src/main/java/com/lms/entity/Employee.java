package com.lms.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @OneToOne
    @JoinColumn(name="role_id")
    private Role role;

    @OneToOne
    @JoinColumn(name="department_id")
    private Department department;

    @Column(name="total_leave_count")
    private String totalLeaveCount;

    @Column(name="current_leave_count")
    private String currentLeaveCount;
}
