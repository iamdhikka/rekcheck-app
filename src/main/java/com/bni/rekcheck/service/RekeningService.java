package com.bni.rekcheck.service;

import com.bni.rekcheck.model.Rekening;
import com.bni.rekcheck.repository.RekeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RekeningService {

    @Autowired
    private RekeningRepository rekeningRepository;

    public List<Rekening> getAll() {
        return rekeningRepository.findAll();
    }

    public Optional<Rekening> getById(String nomorRekening) {
        return rekeningRepository.findById(nomorRekening);
    }

    public Rekening save(Rekening rekening) {
        return rekeningRepository.save(rekening);
    }

    public void delete(String nomorRekening) {
        rekeningRepository.deleteById(nomorRekening);
    }
}
