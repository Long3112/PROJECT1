package com.example.demo.Controller;

import com.example.demo.model.MuonSach;
import com.example.demo.service.impl.MuonSachService;
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
@RequestMapping("/muonsachs")

public class MuonSachController {
    @Autowired
    private MuonSachService muonSachService;

    @GetMapping("")
    public ResponseEntity<List<MuonSach>> getAll() {
        List<MuonSach> list = muonSachService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
