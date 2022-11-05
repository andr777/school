package ru.hogwarts.school.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
                this.studentService = studentService;
    }

    @PostMapping("/add")
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/getid/{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable long id) {
        Student foundStudent = studentService.findStudent(id);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable long id, @RequestBody Student student) {
        Student foundStudent = studentService.editStudent(id, student);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("/delid/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    // Controller
    @GetMapping("/getage/{age}")
    public Collection<Student> findStudents(@PathVariable int age) {
      if (age > 0) {
            return  studentService.findByAge(age);
        }
        return Collections.emptyList();


    }



}