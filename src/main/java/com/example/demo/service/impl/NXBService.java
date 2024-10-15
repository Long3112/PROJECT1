package com.example.demo.service.impl;

import com.example.demo.model.NXB;
import com.example.demo.repository.NXBRepository;
import com.example.demo.service.INXBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NXBService implements INXBService {

    @Autowired
    private NXBRepository nxbRepository;

    @Override
    public List<NXB> findAll() {
        return nxbRepository.findAll();
    }

    @Override
    public NXB findById(Long id) {
        return nxbRepository.findById(id).get(); // Using get() directly
    }

    @Override
    public void save(NXB nxb) {
        nxbRepository.save(nxb); // Save the NXB object
    }

    @Override
    public void remove(Long id) {
        nxbRepository.deleteById(id); // Delete by ID
    }
}
