package com.honeygroup.portailunifier.mapper;

import com.honeygroup.portailunifier.bo.DemandeLead;
import com.honeygroup.portailunifier.bo.response.LeadResponse;
import com.honeygroup.portailunifier.bo.DetailsSpecifiques;
import org.mapstruct.*;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface LeadMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "prestation.id", target = "prestationId")
    @Mapping(source = "prestation.titreService", target = "prestationTitre")
    @Mapping(target = "statut", expression = "java(mapStatut(lead))")
    @Mapping(target = "details", expression = "java(mapDetails(lead))")
    LeadResponse toResponse(DemandeLead lead);

    // ✅ statut safe
    default String mapStatut(DemandeLead lead) {
        return lead.getStatut() != null ? lead.getStatut().name() : null;
    }

    // ✅ conversion List -> Map
    default Map<String, String> mapDetails(DemandeLead lead) {

        if (lead.getSpecificDetails() == null) {
            return Collections.emptyMap();
        }

        return lead.getSpecificDetails()
                .stream()
                .collect(Collectors.toMap(
                        DetailsSpecifiques::getChampCle,
                        DetailsSpecifiques::getValeur,
                        (oldValue, newValue) -> newValue
                ));
    }
}