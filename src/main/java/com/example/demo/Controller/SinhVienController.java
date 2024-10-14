package com.example.demo.Controller;

import com.example.demo.model.SinhVien;
import com.example.demo.service.impl.SinhVienService;
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
@RequestMapping("/sinhviens")
public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;

    @GetMapping("")
    public ResponseEntity<List<SinhVien>> getAll() {
        List<SinhVien> list = sinhVienService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}