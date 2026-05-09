package com.honeygroup.portailunifier.bo;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;


import enumeration.StatutPrestation;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prestation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String titre;

    @NotBlank
    @Size(min = 20, max = 2000)
    @Column(nullable = false, length = 2000)
    private String description;

    @NotNull
    @DecimalMin(value = "0.01")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal prix;

    @NotNull
    @Min(1)
    @Max(1440)
    @Column(nullable = false)
    private Integer duree; // en minutes

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutPrestation statut;

    // ⚠️ relation sécurisée (éviter boucle JSON)  
    /*
     @OneToMany(mappedBy = "prestation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings; */

}