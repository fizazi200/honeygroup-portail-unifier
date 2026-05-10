package com.honeygroup.portailunifier.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeygroup.portailunifier.bo.DetailsSpecifiques;

public interface DetailsSpecRepository extends JpaRepository<DetailsSpecifiques, Long
> {
}