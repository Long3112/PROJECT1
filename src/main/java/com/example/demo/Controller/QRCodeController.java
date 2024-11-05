package com.example.demo.Controller;

import com.example.demo.model.QRCodeEntity;
import com.example.demo.model.Sach;
import com.example.demo.service.impl.QRCodeSerivce;
import com.example.demo.service.impl.SachService;
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

@Controller
@CrossOrigin("*")
@RequestMapping("/qrcodes")
public class QRCodeController {

    @Autowired
    private QRCodeSerivce qrCodeSerivce; 
    @Autowired
    private SachService sachService;

    @PostMapping("/generate/{bookId}")
    public ResponseEntity<byte[]> generateQRCode(@PathVariable Long bookId, @RequestParam boolean confirmed) {
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

            if (confirmed) {
                QRCodeEntity qrCodeEntity = new QRCodeEntity();
                qrCodeEntity.setQrCodeData(jsonSach);
                qrCodeEntity.setConfirmed(true);
                qrCodeSerivce.save(qrCodeEntity);
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(qrCodeBytes);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
