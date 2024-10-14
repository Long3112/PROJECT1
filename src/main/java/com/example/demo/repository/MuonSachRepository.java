package com.example.demo.repository;

import com.example.demo.model.MuonSach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuonSachRepository extends JpaRepository<MuonSach,Long> {
}
