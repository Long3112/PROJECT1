package com.example.demo.service.impl;

import com.example.demo.model.DanhMuc;
import com.example.demo.model.NXB;
import com.example.demo.model.Sach;
import com.example.demo.repository.DanhMucRepository;
import com.example.demo.repository.NXBRepository;
import com.example.demo.repository.SachRepository;
import com.example.demo.repository.TacGiaRepository;
import com.example.demo.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SearchService implements ISearchService {

    @Autowired
    private SachService sachService;

    @Override
    public List<Sach> searchSach(String searchContent) {
        return sachService.findByTenSach(searchContent);
    }

    @Override
    public List<NXB> searchNXB(String searchContent) {
        return List.of();
    }

    @Override
    public List<DanhMuc> searchDanhMuc(String searchContent) {
        return List.of();
    }
}
