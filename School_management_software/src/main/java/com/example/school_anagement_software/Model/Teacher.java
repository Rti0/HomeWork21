package com.example.school_anagement_software.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "varchar(10) not null")
    private String name;

    @Column(columnDefinition = "int not null")
    private Integer age;


    @Column(columnDefinition = "varchar(20) not null")
    @Email
    private String email;

    @Column(columnDefinition = "int not null")
    private Integer salary;



    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;
}
