package com.honeygroup.portailunifier.controller;



import com.honeygroup.portailunifier.bll.service.impl.LeadService;
import com.honeygroup.portailunifier.bo.request.LeadRequest;
import com.honeygroup.portailunifier.bo.response.LeadResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leads")
@RequiredArgsConstructor
public class LeadController {

    private final LeadService leadService;

    @PostMapping
    public ResponseEntity<LeadResponse> createLead(@RequestBody LeadRequest request) {
        return ResponseEntity.ok(leadService.createLead(request));
    }
}