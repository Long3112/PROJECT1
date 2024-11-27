package com.example.demo.Controller;

import com.example.demo.Response.SachDTO;
import com.example.demo.model.Sach;
import com.example.demo.service.impl.SachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

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
        dto.setTen_sach(sach.getTieude());
        dto.setUrl_anh(sach.getUrlanh());
        dto.setUrl_file(sach.getUrlfile());
        dto.setId(sach.getId());
        dto.setTacgia(sach.getTacgia().stream().map(tg -> tg.getTen_tacgia()).collect(Collectors.toList()));
        dto.setDanhmuc(sach.getDanhmuc().stream().map(dm -> dm.getDanhmucten()).collect(Collectors.toList()));
        return dto;
    }
        // Thêm phương thức để tạo QR Code
    @GetMapping("/qrcode/{bookId}")
    public ResponseEntity<byte[]> generateQRCode(@PathVariable Long bookId) {
        Sach sach = sachService.findById(bookId);

        if (sach == null) {
            return ResponseEntity.notFound().build(); 
        }

        String jsonSach = new Gson().toJson(sach); 
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(jsonSach, BarcodeFormat.QR_CODE, 200, 200);
            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(qrImage, "png", baos);
            byte[] qrCodeBytes = baos.toByteArray();

            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(qrCodeBytes);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Trả về 500 nếu có lỗi
        }
    }

}
