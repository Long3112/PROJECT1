package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "muonsach")
public class MuonSach {
    @Id
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "muonsach_sach",
            joinColumns = @JoinColumn(name = "muonsach_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "sach_id", referencedColumnName = "id")
    )
    private List<Sach> sach;


}
