package com.example.demo.service.impl;

import com.example.demo.model.DSCho;
import com.example.demo.repository.DSChoRepository;
import com.example.demo.service.IDSChoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
    @Service
public class DSChoService implements IDSChoService {
    @Autowired
    private DSChoRepository dsChoRepository;
    @Override
    public List<DSCho> findAll() {
        return dsChoRepository.findAll();
    }

    @Override
    public DSCho findById(Long id) {
        return null;
    }

    @Override
    public void save(DSCho dsCho) {

    }

    @Override
    public void remove(Long id) {

    }
}
