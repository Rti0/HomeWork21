package com.example.school_anagement_software.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "varchar(10) not null")
    private String name;


    @Column(columnDefinition = "int not null")
    private Integer age;


    @Column(columnDefinition = "varchar(10) not null")
    private String major;


    //Many to Many

    @ManyToMany
    private Set<Course> courses;
}
