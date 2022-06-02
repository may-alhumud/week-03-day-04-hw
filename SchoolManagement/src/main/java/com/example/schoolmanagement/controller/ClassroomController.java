package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.DTO.API;
import com.example.schoolmanagement.DTO.ClassroomDTO;
import com.example.schoolmanagement.modle.Classroom;
import com.example.schoolmanagement.modle.Student;
import com.example.schoolmanagement.modle.Teacher;
import com.example.schoolmanagement.repository.ClassroomRepository;
import com.example.schoolmanagement.repository.StudentRepository;
import com.example.schoolmanagement.repository.TeacherRepository;
import com.example.schoolmanagement.service.ClassroomService;
import com.example.schoolmanagement.service.TeacherServicce;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/classroom")
public class ClassroomController {
    private final ClassroomService classroomService;
    private final ClassroomRepository classroomRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    Logger logger= LoggerFactory.getLogger(ClassroomController.class);


    @GetMapping
    public ResponseEntity<List<Classroom>> getClassroom(){
        logger.info("get all classroom");
        List<Classroom> classrooms=classroomService.getClassroom();
        return ResponseEntity.status(HttpStatus.OK).body(classrooms);
    }

    @PostMapping("/register")
    public ResponseEntity<API> addClassroom(@RequestBody @Valid Classroom classroom) {
        logger.info("add classroom");
        classroomService.addClassroom(classroom);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new API("New user added !",201));
    }


    @GetMapping("/classroom1/{id}")
    public ResponseEntity<API> checkClassroomIsValid(@PathVariable Integer id){
        logger.info("check classroom is valid");
        classroomService.checkClassroom(id);
        return ResponseEntity.status(HttpStatus.OK).body(new API("Valid user",200));
    }



    @PostMapping("/teacher-add")
    public ResponseEntity addClassroomforTeacher(@RequestBody ClassroomDTO classroomDTO){
        logger.info("add teacher in classroom");
        Teacher teacher=teacherRepository.findById(classroomDTO.getTeacherId()).get();
        Classroom classroom= new Classroom(null,classroomDTO.getName(),null,teacher);
        teacher.getClassroomSet().add(classroom);
        classroomRepository.save(classroom);
        return ResponseEntity.status(HttpStatus.OK).body(classroomRepository.findAll());
    }

    @PostMapping("meal/{studentId}/{classroomId}")
    public ResponseEntity addClassroomStudent(@PathVariable Integer studentId,@PathVariable Integer classroomId){
        logger.info("add student in classroom");
        Classroom classroom=classroomRepository.findById(classroomId).get();
        Student student=studentRepository.findById(studentId).get();
        classroom.getStudentset().add(student);
        classroomRepository.save(classroom);
        return ResponseEntity.status(HttpStatus.OK).body(classroomRepository.findAll());
    }


}
