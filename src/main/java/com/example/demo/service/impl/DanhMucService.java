package com.example.demo.service.impl;

import com.example.demo.model.DanhMuc;
import com.example.demo.repository.DanhMucRepository;
import com.example.demo.service.IDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public void save(DanhMuc danhMuc) {

    }

    @Override
    public void remove(Long id) {

    }
}
