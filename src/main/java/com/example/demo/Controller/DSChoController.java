package com.example.demo.Controller;

import com.example.demo.model.DSCho;
import com.example.demo.service.impl.DSChoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody DSCho dsCho) {
        dsChoService.save(dsCho);
        String message = "Add success";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody DSCho dsCho) {
        dsCho.setId(id);
        dsChoService.save(dsCho);
        String message = "Edit success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        dsChoService.remove(id);
        String message = "Deleted success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<DSCho> findById(@PathVariable Long id) {
        DSCho dsCho = dsChoService.findById(id);
        return new ResponseEntity<>(dsCho, HttpStatus.OK);
    }
}
