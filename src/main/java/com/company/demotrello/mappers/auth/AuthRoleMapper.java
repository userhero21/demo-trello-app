package com.company.demotrello.mappers.auth;

import com.company.demotrello.dtos.auth.AuthRoleCreateDTO;
import com.company.demotrello.dtos.auth.AuthRoleDTO;
import com.company.demotrello.entities.auth.AuthRole;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthRoleMapper {
    AuthRoleDTO toDTO(AuthRole entity);

    List<AuthRoleDTO> toDTO(List<AuthRole> entities);

    AuthRole fromCreateDTO(AuthRoleCreateDTO dto);
}
