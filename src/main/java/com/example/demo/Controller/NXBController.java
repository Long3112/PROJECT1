package com.example.demo.Controller;

import com.example.demo.model.NXB;
import com.example.demo.service.impl.NXBService;
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
@RequestMapping("/nxb")
public class NXBController {
    @Autowired
    private NXBService nxbService;

    @GetMapping("")
    public ResponseEntity<List<NXB>> getAll() {
        List<NXB> list = nxbService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
