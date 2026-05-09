package com.honeygroup.portailunifier.controller;

import com.honeygroup.portailunifier.bo.request.PoleRequest;
import com.honeygroup.portailunifier.bo.response.PoleResponse;
import com.honeygroup.portailunifier.bll.service.PoleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poles")
@RequiredArgsConstructor
@CrossOrigin
public class PoleController {

    private final PoleService poleService;

    // ======================
    // CREATE
    // ======================
    @PostMapping
    public PoleResponse create(@Valid @RequestBody PoleRequest request) {
        return poleService.create(request);
    }

    // ======================
    // GET ALL
    // ======================
    @GetMapping
    public List<PoleResponse> getAll() {
        return poleService.getAll();
    }

    // ======================
    // GET BY ID
    // ======================
    @GetMapping("/{id}")
    public PoleResponse getById(@PathVariable("id") Long id) {
        return poleService.getById(id);
    }

    // ======================
    // GET BY NOM
    // ======================
    @GetMapping("/search")
    public PoleResponse getByNom(@RequestParam String nom) {
        return poleService.getByNom(nom);
    }

    // ======================
    // DELETE
    // ======================
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        poleService.deleteById(id);
    }
}