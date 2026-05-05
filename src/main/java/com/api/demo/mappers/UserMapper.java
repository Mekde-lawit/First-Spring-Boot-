package com.api.demo.mappers;

import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.api.demo.dtos.RegisterUserRequest;
import com.api.demo.dtos.UpdateUserRequest;
import com.api.demo.dtos.UserDto;
import com.api.demo.models.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // @Mapping(target = "createdAt", expression =
    // "java(java.time.LocalDateTime.now())")
    // @Mapping(target = "phoneNumber", ignore = true)
    UserDto toDto(User user);

    User toEntity(RegisterUserRequest request);

    void update(UpdateUserRequest request, @MappingTarget User user);
}
