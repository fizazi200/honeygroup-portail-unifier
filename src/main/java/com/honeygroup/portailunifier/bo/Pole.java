package com.honeygroup.portailunifier.bo;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "poles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pole {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    // ❌ pas de validation ici (DTO s'en charge)

	    @Column(nullable = false, unique = true, length = 100)
	    private String nom;

	    @Column(nullable = false, length = 1000)
	    private String description;

	/*    @OneToMany(mappedBy = "pole", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Prestation> prestations;*/
	
}