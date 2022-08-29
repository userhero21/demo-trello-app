package com.company.demotrello.mappers;

import com.company.demotrello.dtos.UserRegisterDTO;
import com.company.demotrello.dtos.auth.AuthUserDTO;
import com.company.demotrello.entities.auth.AuthUser;
import org.mapstruct.Mapper;


/**
 * @author "Elmurodov Javohir"
 * @since 19/08/22/15:28 (Friday)
 * spring-boot-features/IntelliJ IDEA
 */

@Mapper(componentModel = "spring")
public interface AuthUserMapper {
    AuthUser fromRegisterDTO(UserRegisterDTO dto);

    AuthUserDTO toDTO(AuthUser domain);
}
