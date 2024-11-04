package com.example.demo.Response;

import com.example.demo.model.TacGia;
import lombok.Data;

import java.util.List;

@Data
public class SachDTO {
    private String ten_sach;
    private String url_anh;
    private String url_file;
    private Long id;
    private List<String> tacgia;
    private List<String> danhmuc;
}
