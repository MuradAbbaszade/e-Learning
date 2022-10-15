package com.company.entity;

import com.company.common.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="student",schema = "public")
public class StudentEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @ManyToMany(mappedBy = "studentEntityList",fetch = FetchType.EAGER)
    private List<CourseEntity> courseEntityList;
}
