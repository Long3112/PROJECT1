package com.example.demo.service.impl;

import com.example.demo.model.SinhVien;
import com.example.demo.repository.SinhVienRepository;
import com.example.demo.service.ISinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SinhVienService implements ISinhVienService {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Override
    public List<SinhVien> findAll() {
        return sinhVienRepository.findAll();
    }

    @Override
    public SinhVien findById(Long id) {
        return sinhVienRepository.findById(id).get(); // Using get() directly
    }

    @Override
    public void save(SinhVien sinhVien) {
        sinhVienRepository.save(sinhVien); // Save the SinhVien object
    }

    @Override
    public void remove(Long id) {
        sinhVienRepository.deleteById(id); // Delete by ID
    }
}

