package com.github.xenteros.mapper;

import com.github.xenteros.dto.UserDTO;
import com.github.xenteros.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    @Mappings({
            @Mapping(source = "username", target = "login")
    })
    UserDTO toUserDTO(User user);
    List<UserDTO> toUserDTO(Collection<User> users);
}
