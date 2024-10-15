package com.example.demo.Controller;

import com.example.demo.model.TacGia;
import com.example.demo.service.impl.TacGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody TacGia tacGia) {
        tacGiaService.save(tacGia);
        String message = "Add success";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody TacGia tacGia) {
        tacGia.setId(id);
        tacGiaService.save(tacGia);
        String message = "Edit success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        tacGiaService.remove(id);
        String message = "Deleted success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TacGia> findById(@PathVariable Long id) {
        TacGia tacGia = tacGiaService.findById(id);
        return new ResponseEntity<>(tacGia, HttpStatus.OK);
    }
}