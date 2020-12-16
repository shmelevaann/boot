package ru.chiffa.springboot.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.chiffa.springboot.model.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class StudentRepository {
    private List<Student> students;

    @PostConstruct
    private void init() {
        students = new ArrayList<>(Arrays.asList(
                new Student(1, "First", 10),
                new Student(2, "Second", 20),
                new Student(3, "Third", 30)
        ));
    }

    public List<Student> findAll() {
        return Collections.unmodifiableList(students);
    }


    public void deleteById(Integer id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
