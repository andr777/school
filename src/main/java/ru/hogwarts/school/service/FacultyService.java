package ru.hogwarts.school.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

@Service
public class FacultyService {

 //   private final HashMap<Long, Faculty> faculties = new HashMap<>();
  //  private long count = 0;
private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
                return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty editFaculty(long id, Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findByColor(String color) {
        return facultyRepository.findAllByColor(color);
    }


    public Collection<Faculty> findAllByColorIgnoreCaseOrNameIgnoreCase(String nameorcolor){
        return facultyRepository.findAllByColorIgnoreCaseOrNameIgnoreCase(nameorcolor,  nameorcolor);
    }

    public Collection<Object> findMyFacultyName(String namefacylty) {
        return facultyRepository.findMyFacultyName(namefacylty);
    }
}
