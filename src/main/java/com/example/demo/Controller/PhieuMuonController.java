package com.example.demo.Controller;

import com.example.demo.model.PhieuMuon;
import com.example.demo.service.impl.PhieuMuonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/phieumons")
public class PhieuMuonController {
    @Autowired
    private PhieuMuonService phieuMuonService;

    @GetMapping("")
    public ResponseEntity<List<PhieuMuon>> getAll() {
        List<PhieuMuon> list = phieuMuonService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}