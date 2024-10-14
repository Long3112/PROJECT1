package com.example.demo.repository;

import com.example.demo.model.NXB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NXBRepository extends JpaRepository<NXB,Long> {
}
