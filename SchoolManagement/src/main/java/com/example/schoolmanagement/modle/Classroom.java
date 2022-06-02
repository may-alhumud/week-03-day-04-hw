package com.example.schoolmanagement.modle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    private Integer id;
    @NotEmpty
    private String name;

    @ManyToMany(mappedBy = "classrooms",cascade = CascadeType.ALL)
    private Set<Student> studentset;

    @ManyToOne
    @JsonIgnore
    private Teacher teachers;


}
