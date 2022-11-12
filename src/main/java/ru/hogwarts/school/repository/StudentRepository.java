package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

   Collection<Student> findAllByAge(int age);

   Collection<Student> findByAgeBetween(int min, int max);


   @Transactional(readOnly = true)
   @Query(nativeQuery = true, value = "SELECT faculty.id, faculty.color, faculty.name FROM student, faculty where student.faculty_id = faculty.id and student.name=:namestudent ;")
   Collection<Object> findMyFacultyNameStudent(String namestudent);

}
