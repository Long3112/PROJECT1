package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity

public class Sach {
    //TacGia, DanhMuc, NXB
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tieude;
    private int sotrang;
    private String isbn;
    private String mota;
    private String urlanh;
    private String urlfile;

    //TacGia
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinTable(name = "sach_tacgia",
    joinColumns = {
            @JoinColumn(name = "sach_id", referencedColumnName = "id"),

    },
    inverseJoinColumns = {
            @JoinColumn(name = "tacgia_id", referencedColumnName = "id")
    })
    private List<TacGia> tacgia;
    //DanhMuc
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinTable(name = "sach_danhmuc",
            joinColumns = {
                    @JoinColumn(name = "sach_id", referencedColumnName = "id"),

            },
            inverseJoinColumns = {
                    @JoinColumn(name = "danhmuc_id", referencedColumnName = "id")
            })
    private List<DanhMuc> danhmuc;
    //NXB
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinTable(name = "sach_nxb",
            joinColumns = {
                    @JoinColumn(name = "sach_id", referencedColumnName = "id"),

            },
            inverseJoinColumns = {
                    @JoinColumn(name = "nxb_id", referencedColumnName = "id")
            })
    private List<NXB> nxb;
}
