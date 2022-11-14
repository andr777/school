package ru.hogwarts.school.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
                this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> editStudent(@RequestParam long id, @RequestBody Student student) {
        Student foundStudent = studentService.editStudent(id, student);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentInfo(@RequestParam("id") long id) {
        Student foundStudent = studentService.findStudent(id);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    // Controller
    @GetMapping("/age")
    public Collection<Student> findStudents(@RequestParam("age") int age) {
        return studentService.findByAge(age);
    }

    @DeleteMapping("/{delid}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("delid") long delid) {
        studentService.deleteStudent(delid);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/ageminmax")
    public Collection<Student> findByAgeBetween(@RequestParam("min") int min, @RequestParam("max") int max) {
        return studentService.findByAgeBetween(min, max);
    }

    @GetMapping("/faculty")
    public Collection<Object> findByNameFaculty(@RequestParam("namestudent") String namestudent) {
        return studentService.findMyFacultyNameStudent(namestudent);

    }




}