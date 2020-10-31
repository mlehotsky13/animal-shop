package com.animalshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.animalshop.model.User;
import com.animalshop.model.dto.UserDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	UserDto userToUserDto(User user);

	User userDtoToUser(UserDto userDto);
}
