package com.example.demo.Controller;

import com.example.demo.Response.SachDTO;
import com.example.demo.model.Sach;
import com.example.demo.service.impl.SachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin("*")
@RequestMapping("/sachs")
public class SachController {
    @Autowired
    private SachService sachService;

    @GetMapping("")
    public List<SachDTO> getAll() {
        List<Sach> list = sachService.findAll();
        return list.stream().map(this::convertToDTO).collect(Collectors.toList());

    }
    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody Sach sach) {
        sachService.save(sach);
        String message = "Add success";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody Sach sach) {
        sach.setId(id);
        sachService.save(sach);
        String message = "Edit success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        sachService.remove(id);
        String message = "Deleted success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Sach> findById(@PathVariable Long id) {
        Sach sach = sachService.findById(id);
        return new ResponseEntity<>(sach, HttpStatus.OK);
    }

    private SachDTO convertToDTO(Sach sach) {
        SachDTO dto = new SachDTO();
        dto.setTen_sach(sach.getTen_sach());
        dto.setUrl_anh(sach.getUrl_anh());
        dto.setUrl_file(sach.getUrl_file());
        dto.setId(sach.getId());
        dto.setTacgia(sach.getTacgia().stream().map(tg -> tg.getTen_tacgia()).collect(Collectors.toList()));
        dto.setDanhmuc(sach.getDanhmuc().stream().map(dm -> dm.getTen_danhmuc()).collect(Collectors.toList()));
        return dto;
    }

}