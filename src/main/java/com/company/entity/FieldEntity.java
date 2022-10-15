package com.company.entity;

import com.company.common.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="field",schema = "public")
public class FieldEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "fieldEntity")
    private List<CourseEntity> courseEntityList;
}
