package com.company.demotrello.mappers.auth;

import com.company.demotrello.dtos.auth.AuthUserDTO;
import com.company.demotrello.dtos.config.UserRegisterDTO;
import com.company.demotrello.entities.auth.AuthUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthUserMapper {
    AuthUser fromRegisterDTO(UserRegisterDTO dto);

    AuthUserDTO toDTO(AuthUser domain);
}
