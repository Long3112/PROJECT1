package com.example.demo.Controller;

import com.example.demo.model.DanhMuc;
import com.example.demo.service.impl.DanhMucService;
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
@RequestMapping("/danhmucs")

public class DanhMucController {
    @Autowired
    private DanhMucService danhMucService;

    @GetMapping("")
    public ResponseEntity<List<DanhMuc>> getAll() {
        List<DanhMuc> list = danhMucService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
