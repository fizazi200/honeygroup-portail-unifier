package com.honeygroup.portailunifier.bll.service.impl;

import com.honeygroup.portailunifier.bo.*;
import com.honeygroup.portailunifier.bo.request.LeadRequest;
import com.honeygroup.portailunifier.bo.response.LeadResponse;
import com.honeygroup.portailunifier.mapper.LeadMapper;
import com.honeygroup.portailunifier.repo.DemandeLeadRepository;
import com.honeygroup.portailunifier.repo.PrestationRepository;
import com.honeygroup.portailunifier.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LeadService {

    private final DemandeLeadRepository demandeLeadRepository;
    private final UserRepository userRepository;
    private final PrestationRepository prestationRepository;
    private final LeadMapper leadMapper;

    @Transactional
    public LeadResponse createLead(LeadRequest request) {

        validateDetails(request.getDetails());

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User introuvable"));
//a voir
        Prestation prestation = prestationRepository.findById(request.getPrestationId())
                .orElseThrow(() -> new RuntimeException("Prestation introuvable"));

        // 🟢 création lead
        DemandeLead lead = DemandeLead.builder()
                .user(user)
                .prestation(prestation)
                .source(request.getSource())
                .build();

        // 🟢 mapping details -> entity
        List<DetailsSpecifiques> detailsList = request.getDetails()
                .entrySet()
                .stream()
                .map(entry -> DetailsSpecifiques.builder()
                        .champCle(entry.getKey())
                        .valeur(entry.getValue())
                        .demandeLead(lead)
                        .build()
                )
                .toList();

        lead.setSpecificDetails(detailsList);

        DemandeLead saveDemandeLead = demandeLeadRepository.save(lead);

        return leadMapper.toResponse(saveDemandeLead);
    }

    // 🔥 validation simple
    private void validateDetails(Map<String, String> details) {
        if (details == null || details.isEmpty()) {
            throw new RuntimeException("Details obligatoires");
        }
    }
}