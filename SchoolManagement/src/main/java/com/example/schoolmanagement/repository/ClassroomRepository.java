package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.modle.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom,Integer> {
}
