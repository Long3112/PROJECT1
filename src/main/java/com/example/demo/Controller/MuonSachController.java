package com.example.demo.Controller;

import com.example.demo.model.MuonSach;
import com.example.demo.service.impl.MuonSachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody MuonSach muonSach) {
        muonSachService.save(muonSach);
        String message = "Add success";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody MuonSach muonSach) {
        muonSach.setId(id);
        muonSachService.save(muonSach);
        String message = "Edit success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        muonSachService.remove(id);
        String message = "Deleted success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<MuonSach> findById(@PathVariable Long id) {
        MuonSach muonSach = muonSachService.findById(id);
        return new ResponseEntity<>(muonSach, HttpStatus.OK);
    }
}
