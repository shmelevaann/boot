package ru.chiffa.springboot.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.chiffa.springboot.model.Student;
import ru.chiffa.springboot.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    public List<Student> findByScore(Integer minScore, Integer maxScore) {
        List<Student> result = studentRepository.findAll();
        if(minScore != null) {
            result = result.stream()
                    .filter(s -> s.getScore() >= minScore)
                    .collect(Collectors.toList());
        }
        if(maxScore !=null) {
            result = result.stream()
                    .filter(s -> s.getScore() <= maxScore)
                    .collect(Collectors.toList());
        }
        return result;
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }
}
