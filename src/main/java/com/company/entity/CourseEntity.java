package com.company.entity;

import com.company.common.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name="course",schema = "public")
@Entity
@NoArgsConstructor
public class CourseEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
    @Column(name="image")
    private String image;
    @ManyToOne
    @JoinColumn(name="field_id",referencedColumnName = "id")
    private FieldEntity fieldEntity;
    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private UserEntity teacherUserEntity;
    @ManyToMany
    @JoinTable(
            name = "course_user",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> studentUserEntityList;
    @OneToMany(mappedBy = "courseEntity")
    private List<VideoEntity> videoEntityList;

}
