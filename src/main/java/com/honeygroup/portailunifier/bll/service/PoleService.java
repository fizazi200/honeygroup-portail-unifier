package com.honeygroup.portailunifier.bll.service;



import java.util.List;

import com.honeygroup.portailunifier.bo.request.PoleRequest;
import com.honeygroup.portailunifier.bo.response.PoleResponse;

public interface PoleService {

    PoleResponse create(PoleRequest request);

    List<PoleResponse> getAll();

    PoleResponse getById(Long id);

    PoleResponse update(Long id, PoleRequest request);

    void delete(Long id);

    PoleResponse getByNom(String nom);

    void deleteById(Long id);
}