package com.example.demo.service.impl;

import com.example.demo.model.Sach;
import com.example.demo.repository.SachRepository;
import com.example.demo.service.ISachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SachService implements ISachService {

    @Autowired
    private SachRepository sachRepository;

    @Override
    public List<Sach> findAll() {
        return sachRepository.findAll();
    }

    @Override
    public Sach findById(Long id) {
        return sachRepository.findById(id).get(); // Using get() directly
    }

    public List<Sach> findByTenSach(String tenSach) {
        return sachRepository.findByTieude(tenSach);
    }

    @Override
    public void save(Sach sach) {
        sachRepository.save(sach); // Save the Sach object
    }

    @Override
    public void remove(Long id) {
        sachRepository.deleteById(id); // Delete by ID
    }
}

