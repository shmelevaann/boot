package ru.chiffa.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private int score;

}
