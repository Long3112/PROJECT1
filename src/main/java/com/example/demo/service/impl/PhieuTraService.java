package com.example.demo.service.impl;

import com.example.demo.model.PhieuTra;
import com.example.demo.repository.PhieuTraRepository;
import com.example.demo.service.IPhieuTraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhieuTraService implements IPhieuTraService {

    @Autowired
    private PhieuTraRepository phieuTraRepository;

    @Override
    public List<PhieuTra> findAll() {
        return phieuTraRepository.findAll();
    }

    @Override
    public PhieuTra findById(Long id) {
        return phieuTraRepository.findById(id).get(); // Using get() directly
    }

    @Override
    public void save(PhieuTra phieuTra) {
        phieuTraRepository.save(phieuTra); // Save the PhieuTra object
    }

    @Override
    public void remove(Long id) {
        phieuTraRepository.deleteById(id); // Delete by ID
    }
}

