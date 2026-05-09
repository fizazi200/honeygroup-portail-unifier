package com.honeygroup.portailunifier.bo.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PoleRequest {

	 @NotBlank(message = "{pole.nom.required}")
	    @Size(min = 3, max = 100, message = "{pole.nom.size}")
	    private String nom;

	    @NotBlank(message = "{pole.description.required}")
	    @Size(min = 10, max = 1000, message = "{pole.description.size}")
	    private String description;
}