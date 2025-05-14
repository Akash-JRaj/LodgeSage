package com.ajayaraj.lodgesage.controllers;

import com.ajayaraj.lodgesage.dtos.LodgeDto;
import com.ajayaraj.lodgesage.mappers.LodgeMapper;
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

    @Autowired
    LodgeMapper lodgeMapper;

    @GetMapping
    public ResponseEntity<List<LodgeDto>> getAllLodges() {
        List<Lodge> lodges = lodgeService.getAllLodges();
        List<LodgeDto> lodgeDtos = lodgeMapper.toDtoList(lodges);
        return ResponseEntity.ok(lodgeDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LodgeDto> getLodgeById(@PathVariable Long id) {
        Lodge lodge = lodgeService.getLodgeById(id);
        if (lodge != null) {
            return ResponseEntity.ok(lodgeMapper.toDto(lodge));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<LodgeDto> addLodge(@RequestBody LodgeDto lodgeDto) {
        Lodge lodge = lodgeMapper.toEntity(lodgeDto);
        Lodge createdLodge = lodgeService.addLodge(lodge);
        return ResponseEntity.status(201).body(lodgeMapper.toDto(createdLodge));
    }

    @PutMapping
    public ResponseEntity<LodgeDto> updateLodge(@RequestBody LodgeDto lodgeDto) {
        Lodge lodge = lodgeMapper.toEntity(lodgeDto);
        Lodge updatedLodge = lodgeService.updateLodge(lodge);
        if (updatedLodge != null) {
            return ResponseEntity.ok(lodgeMapper.toDto(updatedLodge));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<LodgeDto> deleteLodge(@PathVariable Long id) {
        Lodge deletedLodge = lodgeService.deleteLodge(id);
        if (deletedLodge != null) {
            return ResponseEntity.ok(lodgeMapper.toDto(deletedLodge));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
