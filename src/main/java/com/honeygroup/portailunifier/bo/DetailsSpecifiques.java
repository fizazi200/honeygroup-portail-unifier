package com.honeygroup.portailunifier.bo;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "details_specifiques")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailsSpecifiques {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "champ_cle", nullable = false)
    private String champCle;

    @Column(columnDefinition = "TEXT")
    private String valeur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lead_id", nullable = false)
    private DemandeLead demandeLead;
}