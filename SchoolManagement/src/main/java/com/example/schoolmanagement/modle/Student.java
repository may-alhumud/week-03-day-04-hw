package com.example.schoolmanagement.modle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    private Integer id;
    @NotEmpty
    private String name;
    @NotNull
    private Integer age;
    @NotEmpty
    private String major;


    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Classroom> classrooms;


}
