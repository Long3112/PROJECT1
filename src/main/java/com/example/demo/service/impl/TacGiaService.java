package com.example.demo.service.impl;

import com.example.demo.model.TacGia;
import com.example.demo.repository.TacGiaRepository;
import com.example.demo.service.ITacGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacGiaService implements ITacGiaService {

    @Autowired
    private TacGiaRepository tacGiaRepository;

    @Override
    public List<TacGia> findAll() {
        return tacGiaRepository.findAll();
    }

    @Override
    public TacGia findById(Long id) {
        return tacGiaRepository.findById(id).get(); // Using get() directly
    }

    @Override
    public void save(TacGia tacGia) {
        tacGiaRepository.save(tacGia); // Save the TacGia object
    }

    @Override
    public void remove(Long id) {
        tacGiaRepository.deleteById(id); // Delete by ID
    }
}
