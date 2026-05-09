package com.honeygroup.portailunifier.bo;


import com.fasterxml.jackson.annotation.JsonIgnore;

import enumeration.StatutLead;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "demande_lead")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemandeLead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dateSoumission;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutLead statut;

    @NotBlank
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String source; // site, facebook, google, etc.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prestation_id", nullable = false)
    private Prestation prestation;

    @PrePersist
    public void prePersist() {
        if (dateSoumission == null) {
            dateSoumission = LocalDateTime.now();
        }
        if (statut == null) {
            statut = StatutLead.NOUVEAU;
        }
    }
}