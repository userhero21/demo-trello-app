package com.company.demotrello.services.auth;

import com.company.demotrello.dtos.auth.AuthRoleCreateDTO;
import com.company.demotrello.dtos.auth.AuthRoleDTO;
import com.company.demotrello.entities.auth.AuthRole;
import com.company.demotrello.exceptions.GenericNotFoundException;
import com.company.demotrello.mappers.auth.AuthRoleMapper;
import com.company.demotrello.repository.auth.AuthRoleRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class AuthRoleService {

    private final AuthRoleRepository authRoleRepository;
    private final AuthRoleMapper authRoleMapper;


    //    @PreAuthorize("hasAuthority(T(com.company.demotrello.enums.Permissions).ROLE_READ)")
    public List<AuthRoleDTO> getAll() {
        List<AuthRole> authRoles = authRoleRepository.findAll();
        return authRoleMapper.toDTO(authRoles);
    }

    //    @PreAuthorize("hasAuthority(T(com.company.demotrello.enums.Permissions).ROLE_READ)")
    public AuthRoleDTO get(@NonNull Long id) {
        // TODO: 19/08/22 standardize status codes
        Supplier<GenericNotFoundException> notFoundException = () -> new GenericNotFoundException("Role not found", 404);
        AuthRole authRole = authRoleRepository.findById(id).orElseThrow(notFoundException);
        return authRoleMapper.toDTO(authRole);
    }

    //    @PreAuthorize("hasAuthority(T(com.company.demotrello.enums.Permissions).ROLE_CREATE)")
    public void create(AuthRoleCreateDTO dto) {
        AuthRole authRole = authRoleMapper.fromCreateDTO(dto);
        authRoleRepository.save(authRole);
    }

    //    @PreAuthorize("hasAuthority(T(com.company.demotrello.enums.Permissions).ROLE_DELETE)")
    public void delete(@NonNull Long id) {
        authRoleRepository.deleteById(id);
    }
}
