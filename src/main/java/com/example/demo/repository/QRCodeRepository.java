package com.example.demo.repository;

import com.example.demo.model.QRCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QRCodeRepository extends JpaRepository<QRCodeEntity, Long> {
}
