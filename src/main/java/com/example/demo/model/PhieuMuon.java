package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "phieumuon")
public class PhieuMuon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date ngay_muon;
    private int thoi_han;
    private int so_sachmuon;
}
