package com.example.demo.Controller;

import com.example.demo.model.PhieuTra;
import com.example.demo.service.impl.PhieuTraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody PhieuTra phieuTra) {
        phieuTraService.save(phieuTra);
        String message = "Add success";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody PhieuTra phieuTra) {
        phieuTra.setId(id);
        phieuTraService.save(phieuTra);
        String message = "Edit success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        phieuTraService.remove(id);
        String message = "Deleted success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<PhieuTra> findById(@PathVariable Long id) {
        PhieuTra phieuTra = phieuTraService.findById(id);
        return new ResponseEntity<>(phieuTra, HttpStatus.OK);
    }
}