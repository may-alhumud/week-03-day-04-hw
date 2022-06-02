package com.example.schoolmanagement.modle;

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
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    private Integer id;
    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
   // private Set<Classroom> classrooms;
    private Set<Classroom> classroomSet;



}
