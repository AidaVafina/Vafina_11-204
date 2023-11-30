package ru.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Pet {
    private int id;
    private String name;
    private double height;
    private double weight;
    private String color;
    private String sex;
    private int ownerId;
}
