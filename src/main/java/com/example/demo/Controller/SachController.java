package com.example.demo.Controller;

import com.example.demo.model.Sach;
import com.example.demo.service.impl.SachService;
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
@RequestMapping("/sachs")
public class SachController {
    @Autowired
    private SachService sachService;

    @GetMapping("")
    public ResponseEntity<List<Sach>> getAll() {
        List<Sach> list = sachService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}