package ru.chiffa.springboot.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.chiffa.springboot.services.StudentService;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    @GetMapping()
    public String showAll(Model model,
                          @RequestParam(required = false, name = "min_score") Integer minScore,
                          @RequestParam(required = false, name = "max_score") Integer maxScore) {
        model.addAttribute("students", studentService.findByScore(minScore, maxScore));
        return "students";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id){
        studentService.deleteById(id);
        return "redirect:/students";
    }

}
