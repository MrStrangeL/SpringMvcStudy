package com.springmvcstudy.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private int id;
    private String name;
    private double price;
}
