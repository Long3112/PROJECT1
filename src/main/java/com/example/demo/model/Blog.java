package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    @Column(columnDefinition = "TEXT")
    String content;
    String thumbnail;
    Boolean status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
