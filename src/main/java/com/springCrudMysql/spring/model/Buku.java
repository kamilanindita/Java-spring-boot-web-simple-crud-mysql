package com.springCrudMysql.spring.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;

@Entity
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String penulis;
    private String judul;
    private String kota;
    private String penerbit;
    private Integer tahun;

    @Version
    @Column(name = "optVersion", columnDefinition = "integer DEFAULT 0")
    private Integer version;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public Integer getTahun() {
        return tahun;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
