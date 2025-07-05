package com.bni.rekcheck.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bni.rekcheck.model.Rekening;
import com.bni.rekcheck.service.RekeningService;

@RestController
@RequestMapping("/api/rekening")
public class RekeningController {

    private static final Logger logger = LoggerFactory.getLogger(RekeningController.class);

    @Autowired
    private RekeningService rekeningService;

    @GetMapping
    public List<Rekening> getAll() {
        logger.info("GET all rekening");
        return rekeningService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rekening> getById(@PathVariable("id") String id) {
        logger.info("GET rekening by id: {}", id);
        return rekeningService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rekening create(@RequestBody Rekening rekening) {
        logger.info("POST create rekening: {}", rekening);
        return rekeningService.save(rekening);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rekening> update(@PathVariable String id, @RequestBody Rekening rekeningUpdate) {
        logger.info("PUT update rekening: {}", id);
        return rekeningService.getById(id)
                .map(rekening -> {
                    rekening.setNamaPemilik(rekeningUpdate.getNamaPemilik());
                    rekening.setStatus(rekeningUpdate.getStatus());
                    logger.debug("Updated rekening: {}", rekening);
                    return ResponseEntity.ok(rekeningService.save(rekening));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        logger.warn("DELETE rekening id: {}", id);
        if (rekeningService.getById(id).isPresent()) {
            rekeningService.delete(id);
            return ResponseEntity.ok().build();
        } else {
            logger.error("Rekening not found for delete: {}", id);
            return ResponseEntity.notFound().build();
        }
    }
}
