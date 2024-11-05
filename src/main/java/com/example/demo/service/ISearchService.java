package com.example.demo.service;

import com.example.demo.model.DanhMuc;
import com.example.demo.model.NXB;
import com.example.demo.model.Sach;

import java.util.List;

public interface ISearchService  {
    public List<Sach> searchSach(String searchContent);
    public List<NXB> searchNXB(String searchContent);
    public List<DanhMuc> searchDanhMuc(String searchContent);
}
