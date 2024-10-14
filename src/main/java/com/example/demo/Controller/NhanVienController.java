package com.example.demo.Controller;

import com.example.demo.model.NhanVien;
import com.example.demo.service.impl.NhanVienService;
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
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("")
    public ResponseEntity<List<NhanVien>> getAll() {
        List<NhanVien> list = nhanVienService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}