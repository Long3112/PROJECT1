package com.example.demo.Controller;

import com.example.demo.model.SinhVien;
import com.example.demo.service.impl.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody SinhVien sinhVien) {
        sinhVienService.save(sinhVien);
        String message = "Add success";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody SinhVien sinhVien) {
        sinhVien.setId(id);
        sinhVienService.save(sinhVien);
        String message = "Edit success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        sinhVienService.remove(id);
        String message = "Deleted success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<SinhVien> findById(@PathVariable Long id) {
        SinhVien sinhVien = sinhVienService.findById(id);
        return new ResponseEntity<>(sinhVien, HttpStatus.OK);
    }
}