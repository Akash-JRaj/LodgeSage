package com.ajayaraj.lodgesage.services;

import com.ajayaraj.lodgesage.models.Lodge;
import com.ajayaraj.lodgesage.repositories.LodgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LodgeService {

    @Autowired
    LodgeRepository lodgeRepository;

    public Lodge addLodge(Lodge lodge) {
        return lodgeRepository.save(lodge);
    }

    public Lodge updateLodge(Lodge lodge) {

        Lodge existingLodge = lodgeRepository.findById(lodge.getId()).orElse(null);

        if(existingLodge == null) {
            return null;
        }
        return lodgeRepository.save(lodge);
    }

    public Lodge deleteLodge(Long id) {

        Lodge existingLodge = lodgeRepository.findById(id).orElse(null);

        if(existingLodge == null) {
            return null;
        }

        lodgeRepository.deleteById(id);
        return existingLodge;
    }

    public Lodge getLodgeById(Long id) {
        return lodgeRepository.findById(id).orElse(null);
    }

    public List<Lodge> getAllLodges() {
        return lodgeRepository.findAll();
    }

}
