package org.example.essence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer bookId;
    private String title;
    private String author;
    private Integer age;
    private String description;
    private Integer userId;
}