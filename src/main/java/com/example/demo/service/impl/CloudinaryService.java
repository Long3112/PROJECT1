//package com.example.demo.service.impl;
//import com.cloudinary.Cloudinary;
//import com.cloudinary.utils.ObjectUtils;
//import org.springframework.web.multipart.MultipartFile;
//import java.io.IOException;
//import java.util.Map;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CloudinaryService {
//    private final Cloudinary cloudinary;
//
//    public CloudinaryService(Cloudinary cloudinary) {
//        this.cloudinary = cloudinary;
//    }
//
//    public Map uploadFile(MultipartFile file, String folderName) throws IOException {
//        return cloudinary.uploader().upload(file.getBytes(),
//                ObjectUtils.asMap(
//                        "folder", folderName
//                ));
//    }
//
//    public Map uploadVideo(MultipartFile file, String folderName) throws IOException {
//        return cloudinary.uploader().upload(file.getBytes(),
//                ObjectUtils.asMap(
//                        "resource_type", "video",
//                        "folder", folderName
//                ));
//    }
//
//    public Map uploadAudio(MultipartFile file, String folderName) throws IOException {
//        return cloudinary.uploader().upload(file.getBytes(),
//                ObjectUtils.asMap(
//                        "resource_type", "audio",
//                        "folder", folderName
//                ));
//    }
//
//    public Map uploadPdf(MultipartFile file, String folderName) throws IOException {
//        return cloudinary.uploader().upload(file.getBytes(),
//                ObjectUtils.asMap(
//                        "resource_type", "pdf",
//                        "folder", folderName
//                ));
//    }
//}
