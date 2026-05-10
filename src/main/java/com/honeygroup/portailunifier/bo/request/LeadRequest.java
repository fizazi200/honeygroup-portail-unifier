package com.honeygroup.portailunifier.bo.request;

import java.util.Map;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class LeadRequest {

    @NotNull(message = "L'utilisateur est obligatoire")
    private Long userId;

    @NotNull(message = "La prestation est obligatoire")
    private Long prestationId;

    @NotBlank(message = "La source est obligatoire")
    @Size(min = 3, max = 100)
    private String source;
    
    @NotNull(message = "Les détails sont obligatoires")
    private Map<String, String> details;
}