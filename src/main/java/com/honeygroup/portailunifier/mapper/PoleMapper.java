package com.honeygroup.portailunifier.mapper;

import org.mapstruct.Mapper;

import com.honeygroup.portailunifier.bo.Pole;
import com.honeygroup.portailunifier.bo.request.PoleRequest;
import com.honeygroup.portailunifier.bo.response.PoleResponse;

@Mapper(componentModel = "spring")
public interface PoleMapper {

    PoleResponse toResponse(Pole pole);

    Pole toEntity(PoleRequest request);
}