package com.example.demo.Controller;

import com.example.demo.model.PhieuMuon;
import com.example.demo.service.impl.PhieuMuonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody PhieuMuon phieuMuon) {
        phieuMuonService.save(phieuMuon);
        String message = "Add success";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody PhieuMuon phieuMuon) {
        phieuMuon.setId(id);
        phieuMuonService.save(phieuMuon);
        String message = "Edit success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        phieuMuonService.remove(id);
        String message = "Deleted success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<PhieuMuon> findById(@PathVariable Long id) {
        PhieuMuon phieuMuon = phieuMuonService.findById(id);
        return new ResponseEntity<>(phieuMuon, HttpStatus.OK);
    }
}