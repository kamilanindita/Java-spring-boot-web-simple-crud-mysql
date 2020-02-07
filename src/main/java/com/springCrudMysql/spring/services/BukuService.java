package com.springCrudMysql.spring.services;

import com.springCrudMysql.spring.model.Buku;
import java.util.List;

public interface BukuService {
    List <Buku> ListBuku();
    Buku savaOrUpdate(Buku buku);
    Buku getIdBuku(Integer id);
    void hapus (Integer id);
}
