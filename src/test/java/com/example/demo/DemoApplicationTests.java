package com.example.demo;

import com.example.demo.model.DanhMuc;
import com.example.demo.model.NXB;
import com.example.demo.model.Sach;
import com.example.demo.model.TacGia;
import com.example.demo.repository.DanhMucRepository;
import com.example.demo.repository.NXBRepository;
import com.example.demo.repository.SachRepository;
import com.example.demo.repository.TacGiaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    TacGiaRepository tacGiaRepository;
    @Autowired
    DanhMucRepository danhMucRepository;
    @Autowired
    NXBRepository nxbRepository;
    @Autowired
    SachRepository sachRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void tacGiaFaker() {
        Faker faker = new Faker();
        for (int i = 0; i < 50; i++) {
            TacGia tacGia = new TacGia();
            tacGia.setTen_tacgia(faker.name().fullName());
            tacGiaRepository.save(tacGia);
        }
    }

    @Test
    void nxbFaker() {
        Faker faker = new Faker();
        for (int i = 0; i < 15; i++) {
            NXB nxb = new NXB();
            nxb.setTen_nxb(faker.company().name());
            nxbRepository.save(nxb);
        }
    }

    @Test
    void danhMucFaker() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            DanhMuc danhMuc = new DanhMuc();
            danhMuc.setDanhmucten(faker.book().genre());
            danhMucRepository.save(danhMuc);
        }
    }

    @PersistenceContext
    private EntityManager entityManager;


@Test
void sachFaker() {
    Faker faker = new Faker();
    Random random = new Random();

    List<TacGia> tacGias = tacGiaRepository.findAll();
    List<DanhMuc> danhMucs = danhMucRepository.findAll();
    List<NXB> nxbs = nxbRepository.findAll();
    System.out.println(tacGias.size());
    System.out.println(danhMucs.size());
    System.out.println(nxbs.size());
    List<TacGia> randomTacGias = new ArrayList<>();
    List<DanhMuc> randomDanhMucs = new ArrayList<>();
    List<NXB> randomNXBs = new ArrayList<>();
    for (int j = 0; j < random.nextInt(3) + 1; j++) {
        TacGia randomTacGia = tacGias.get(random.nextInt(tacGias.size()));
        DanhMuc randomDanhMuc = danhMucs.get(random.nextInt(danhMucs.size()));
        NXB randomNXB = nxbs.get(random.nextInt(nxbs.size()));
        if (!randomTacGias.contains(randomTacGia)) {
            randomTacGias.add(randomTacGia);
        }
        if (!randomDanhMucs.contains(randomDanhMuc)) {
            randomDanhMucs.add(randomDanhMuc);
        }
        if (!randomNXBs.contains(randomNXB)) {
            randomNXBs.add(randomNXB);
        }
    }
    for (int i = 0; i < 100; i++) {
        String name = faker.book().title();


    Sach sach = Sach.builder()
            .tieude(name)
            .isbn(faker.number().digits(13))
            .mota(faker.lorem().paragraph(2))
            .urlanh(faker.internet().image())
            .urlfile(faker.internet().url())
            .tacgia(randomTacGias)
            .danhmuc(randomDanhMucs)
            .nxb(randomNXBs)
            .build();
    sachRepository.save(sach);
    }
}




}
