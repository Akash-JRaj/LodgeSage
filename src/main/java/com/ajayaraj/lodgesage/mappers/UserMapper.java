package com.ajayaraj.lodgesage.mappers;

import com.ajayaraj.lodgesage.dtos.UserDto;
import com.ajayaraj.lodgesage.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
