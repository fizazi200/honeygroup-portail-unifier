package com.honeygroup.portailunifier.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeygroup.portailunifier.bo.Pole;

public interface PoleRepository extends JpaRepository<Pole, Long> {

    boolean existsByNom(String nom);
    Optional<Pole> findByNom(String nom);
    
    List<Pole> findAllByOrderByNomAsc();
}