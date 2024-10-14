package com.example.demo.service.impl;

import com.example.demo.model.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.INhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService implements INhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Override
    public List<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien findById(Long id) {
        return null;
    }

    @Override
    public void save(NhanVien nhanVien) {

    }

    @Override
    public void remove(Long id) {

    }
}
