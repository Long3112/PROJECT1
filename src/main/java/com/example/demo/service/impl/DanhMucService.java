package com.example.demo.service.impl;

import com.example.demo.model.DanhMuc;
import com.example.demo.repository.DanhMucRepository;
import com.example.demo.service.IDanhMucService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DanhMucService implements IDanhMucService {

    @Autowired
    private DanhMucRepository danhMucRepository;


    @Override
    public List<DanhMuc> findAll() {
        return danhMucRepository.findAll();
    }

    @Override
    public DanhMuc findById(Long id) {
        return danhMucRepository.findById(id).get();
    }

    @Override
    public void save(DanhMuc danhMuc) {
        danhMucRepository.save(danhMuc);
    }

    @Override
    public void remove(Long id) {
        danhMucRepository.deleteById(id);
    }
}
