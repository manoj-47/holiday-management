package com.lms.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="role")
    private String role;
}
