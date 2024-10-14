package com.example.demo.service.impl;

import com.example.demo.model.PhieuMuon;
import com.example.demo.repository.PhieuMuonRepository;
import com.example.demo.service.IPhieuMuonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhieuMuonService implements IPhieuMuonService {
@Autowired
private PhieuMuonRepository phieuMuonRepository;
    @Override
    public List<PhieuMuon> findAll() {
        return phieuMuonRepository.findAll();
    }

    @Override
    public PhieuMuon findById(Long id) {
        return null;
    }

    @Override
    public void save(PhieuMuon phieuMuon) {

    }

    @Override
    public void remove(Long id) {

    }
}
