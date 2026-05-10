package com.honeygroup.portailunifier.bo;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;


import enumeration.StatutPrestation;


@Entity
@Table(name = "prestation")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Prestation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
    @Column(name = "id_prestation")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pole", nullable = false)
    private Pole pole;

  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_photo")
    private Photo photo; */

    @NotBlank
    @Size(min = 3, max = 100)
    @Column(name = "titre_service", nullable = false)
    private String titreService;
   

    @NotBlank
    @Size(min = 20, max = 2000)
    @Column(nullable = false, length = 2000)
    private String description;

    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutPrestation statut;

    // ⚠️ relation sécurisée (éviter boucle JSON)  
    /*
     @OneToMany(mappedBy = "prestation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings; */

}