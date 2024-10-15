package com.example.demo.Controller;

import com.example.demo.model.DanhMuc;
import com.example.demo.service.impl.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/danhmucs")

public class DanhMucController {
    @Autowired
    private DanhMucService danhMucService;

    @GetMapping("")
    public ResponseEntity<List<DanhMuc>> getAll() {
        List<DanhMuc> list = danhMucService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody DanhMuc danhMuc) {
        danhMucService.save(danhMuc);
        String message = "Add success";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody DanhMuc danhMuc) {
        danhMuc.setId(id);
        danhMucService.save(danhMuc);
        String message = "Edit success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        danhMucService.remove(id);
        String message = "Deleted success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<DanhMuc> findById(@PathVariable Long id) {
        DanhMuc danhMuc = danhMucService.findById(id);
        return new ResponseEntity<>(danhMuc, HttpStatus.OK);
    }
}
