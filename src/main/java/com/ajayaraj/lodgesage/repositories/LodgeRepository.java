package com.ajayaraj.lodgesage.repositories;

import com.ajayaraj.lodgesage.models.Lodge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LodgeRepository extends JpaRepository<Lodge, Long> {
}
