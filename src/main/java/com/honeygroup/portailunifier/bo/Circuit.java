package com.honeygroup.portailunifier.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "circuit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Circuit extends Prestation {

    @NotBlank
    @Size(min = 20, max = 2000)
    @Column(name = "description_longue", length = 2000)
    private String descriptionLongue;

    @NotBlank
    @Column(nullable = false)
    private String itineraire;

    @NotBlank
    @Column(nullable = false)
    private String duree;
}
