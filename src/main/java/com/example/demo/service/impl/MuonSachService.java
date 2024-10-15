package com.example.demo.service.impl;

import com.example.demo.model.MuonSach;
import com.example.demo.repository.MuonSachRepository;
import com.example.demo.service.IMuonSachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuonSachService implements IMuonSachService {

    @Autowired
    private MuonSachRepository muonSachRepository;

    @Override
    public List<MuonSach> findAll() {
        return muonSachRepository.findAll();
    }

    @Override
    public MuonSach findById(Long id) {
        return muonSachRepository.findById(id).get(); // Using get() directly
    }

    @Override
    public void save(MuonSach muonSach) {
        muonSachRepository.save(muonSach);
    }

    @Override
    public void remove(Long id) {
        muonSachRepository.deleteById(id);
    }
}