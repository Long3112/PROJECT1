package com.example.demo.service.impl;

import com.example.demo.model.QRCodeEntity;
import com.example.demo.repository.QRCodeRepository;
import com.example.demo.service.IQRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QRCodeSerivce implements IQRCodeService {
    @Autowired
    private QRCodeRepository qrCodeRepository;

    @Override
    public List<QRCodeEntity> findAll() {
        return qrCodeRepository.findAll();
    }

    @Override
    public QRCodeEntity findById(Long id) {
        return qrCodeRepository.findById(id).get();
    }

    @Override
    public void save(QRCodeEntity qrCodeEntity) {
        qrCodeRepository.save(qrCodeEntity);
    }

    @Override
    public void remove(Long id) {
        qrCodeRepository.deleteById(id);

    }
}
