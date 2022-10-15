package com.company.entity;

import com.company.common.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name="course",schema = "public")
@Entity
public class CourseEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
    @ManyToOne
    @JoinColumn(name="field_id",referencedColumnName = "id")
    private FieldEntity fieldEntity;
    @ManyToOne
    @JoinColumn(name="teacher_id",referencedColumnName = "id")
    private TeacherEntity teacherEntity;
    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<StudentEntity> studentEntityList;
    @OneToMany(mappedBy = "courseEntity")
    private List<VideoEntity> videoEntityList;

}
