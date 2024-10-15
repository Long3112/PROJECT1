package com.example.demo.Controller;

import com.example.demo.model.NXB;
import com.example.demo.service.impl.NXBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody NXB nxb) {
        nxbService.save(nxb);
        String message = "Add success";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody NXB nxb) {
        nxb.setId(id);
        nxbService.save(nxb);
        String message = "Edit success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        nxbService.remove(id);
        String message = "Deleted success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<NXB> findById(@PathVariable Long id) {
        NXB nxb = nxbService.findById(id);
        return new ResponseEntity<>(nxb, HttpStatus.OK);
    }
}
