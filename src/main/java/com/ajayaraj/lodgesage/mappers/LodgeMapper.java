package com.ajayaraj.lodgesage.mappers;

import com.ajayaraj.lodgesage.dtos.LodgeDto;
import com.ajayaraj.lodgesage.models.Lodge;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LodgeMapper {
    LodgeDto toDto(Lodge lodge);

    Lodge toEntity(LodgeDto lodgeDto);

    List<LodgeDto> toDtoList(List<Lodge> lodges);

    List<Lodge> toEntityList(List<LodgeDto> lodgeDtos);
}
