package ru.hogwarts.school.service;

import java.util.*;
import java.util.stream.Collectors;

import ru.hogwarts.school.model.Student;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StudentService {

    //  private final HashMap<Long, Student> students = new HashMap<>();
    //  private long count = 0;

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student editStudent(long id, Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }


    // Service
    public Collection<Student> findByAge(int age) {
        List<Student> sortedStudents = getAll().stream()
                .filter(student -> (age == student.getAge()))
                .collect(Collectors.toList());
        if (sortedStudents.isEmpty()) {
            return null;
        }
        return sortedStudents;


    }

    private Collection<Student> getAll() {
        return studentRepository.findAll();
    }
}