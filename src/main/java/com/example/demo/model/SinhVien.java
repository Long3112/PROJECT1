package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sinhvien")
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ten_sv;
    private String gioi_tinh;
    private String ngay_sinh;

    @OneToOne
    private User user;
}
