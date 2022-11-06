package com.cloud.security.userservice.mapper;

import com.cloud.security.userservice.dto.UserDto;
import com.cloud.security.userservice.entity.User;
import java.util.List;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    componentModel = "spring")
public interface UserMapper {

  UserDto toDto(User entity);

  User toEntity(UserDto dto);

  List<User>toListEntity(List<UserDto>listDto);

  List<UserDto>toListDto(List<User>listEntity);
}
