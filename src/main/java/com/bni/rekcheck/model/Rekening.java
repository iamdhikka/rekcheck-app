package com.bni.rekcheck.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rekening")
public class Rekening {

    @Id
    private String nomorRekening;
    private String namaPemilik;
    private String status;

    public Rekening() {}

    public Rekening(String nomorRekening, String namaPemilik, String status) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.status = status;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
