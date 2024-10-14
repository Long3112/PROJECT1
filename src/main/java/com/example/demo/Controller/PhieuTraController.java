package com.example.demo.Controller;

import com.example.demo.model.PhieuTra;
import com.example.demo.service.impl.PhieuTraService;
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
@RequestMapping("/phieutras")
public class PhieuTraController {
    @Autowired
    private PhieuTraService phieuTraService;

    @GetMapping("")
    public ResponseEntity<List<PhieuTra>> getAll() {
        List<PhieuTra> list = phieuTraService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}