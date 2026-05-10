package com.honeygroup.portailunifier.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import enumeration.StatutLead;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "demande_lead")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"user", "prestation", "specificDetails"})
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
    private String source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prestation_id", nullable = false)
    @JsonIgnore
    private Prestation prestation;

    @OneToMany(
            mappedBy = "demandeLead",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DetailsSpecifiques> specificDetails;

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