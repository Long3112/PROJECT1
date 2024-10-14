package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class MuonSach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Sach sach;
}
