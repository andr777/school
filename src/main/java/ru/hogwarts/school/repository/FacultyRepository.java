package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.hogwarts.school.model.Faculty;


import java.util.Collection;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findAllByColor(String color);


    Collection<Faculty> findAllByColorIgnoreCaseOrNameIgnoreCase    (String nameorcolor, String nameorcolor2);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "SELECT student.id, student.age, student.name FROM student, faculty where student.faculty_id = faculty.id and faculty.name=:namefacylty ;")
    Collection<Object> findMyFacultyName(String namefacylty);
}
