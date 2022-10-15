package com.company.entity;

import com.company.common.AbstractEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="video",schema = "public")
public class VideoEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @ManyToOne
    @JoinColumn(name="course_id",referencedColumnName = "id")
    private CourseEntity courseEntity;
}
