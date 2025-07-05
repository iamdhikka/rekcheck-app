package com.bni.rekcheck.repository;

import com.bni.rekcheck.model.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RekeningRepository extends JpaRepository<Rekening, String> {
}
