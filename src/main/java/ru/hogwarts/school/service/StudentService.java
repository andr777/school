package ru.hogwarts.school.service;

import java.util.Collection;
import java.util.Optional;

import ru.hogwarts.school.model.Student;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.repository.StudentRepository;

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
        return studentRepository.findById(id).get();
    }

    public Student editStudent(long id, Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }



// Service
    public Collection<Student> findByAge(int age) {

        return studentRepository.findByAge((long) age);
    }
}