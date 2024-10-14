package com.example.demo.repository;

import com.example.demo.model.PhieuTra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuTraRepository extends JpaRepository<PhieuTra,Long> {
}
