package com.ajayaraj.lodgesage.controllers;

import com.ajayaraj.lodgesage.models.Lodge;
import com.ajayaraj.lodgesage.services.LodgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lodges")
public class LodgeController {

    @Autowired
    LodgeService lodgeService;

    @GetMapping
    public ResponseEntity<List<Lodge>> getAllLodges() {
        List<Lodge> lodges = lodgeService.getAllLodges();
        return ResponseEntity.ok(lodges);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lodge> getLodgeById(@PathVariable Long id) {
        Lodge lodge = lodgeService.getLodgeById(id);
        if (lodge != null) {
            return ResponseEntity.ok(lodge);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Lodge> addLodge(@RequestBody Lodge lodge) {
        Lodge createdLodge = lodgeService.addLodge(lodge);
        return ResponseEntity.status(201).body(createdLodge);
    }

    @PutMapping
    public ResponseEntity<Lodge> updateLodge(@RequestBody Lodge lodge) {
        Lodge updatedLodge = lodgeService.updateLodge(lodge);
        if (updatedLodge != null) {
            return ResponseEntity.ok(updatedLodge);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Lodge> deleteLodge(@PathVariable Long id) {
        Lodge deletedLodge = lodgeService.deleteLodge(id);
        if (deletedLodge != null) {
            return ResponseEntity.ok(deletedLodge);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
