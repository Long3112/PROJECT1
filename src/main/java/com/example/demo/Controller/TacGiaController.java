package com.example.demo.Controller;

import com.example.demo.model.TacGia;
import com.example.demo.service.impl.TacGiaService;
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
@RequestMapping("/tacgias")
public class TacGiaController {
    @Autowired
    private TacGiaService tacGiaService;

    @GetMapping("")
    public ResponseEntity<List<TacGia>> getAll() {
        List<TacGia> list = tacGiaService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}