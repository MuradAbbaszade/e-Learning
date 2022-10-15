package com.company.common;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class AbstractEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
