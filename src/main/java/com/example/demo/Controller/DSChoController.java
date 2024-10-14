package com.example.demo.Controller;

import com.example.demo.model.DSCho;
import com.example.demo.service.impl.DSChoService;
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
@RequestMapping("/dschos")

public class DSChoController {
    @Autowired
    private DSChoService dsChoService;

    @GetMapping("")
    public ResponseEntity<List<DSCho>> getAll() {
        List<DSCho> list = dsChoService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
