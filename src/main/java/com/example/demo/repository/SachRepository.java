package com.example.demo.repository;

import com.example.demo.model.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SachRepository extends JpaRepository<Sach,Long> {
    List<Sach> findByTen_sachContaining(String ndtimkiem);
}
