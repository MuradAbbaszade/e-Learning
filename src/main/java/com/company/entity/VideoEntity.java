package com.company.entity;

import com.company.common.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="video",schema = "public")
public class VideoEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @ManyToOne
    @JoinColumn(name="course_id",referencedColumnName = "id")
    private CourseEntity courseEntity;
}
