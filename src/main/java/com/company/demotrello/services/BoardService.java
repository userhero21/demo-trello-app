//package com.company.demotrello.services;
//
//import com.company.demotrello.repository.BoardRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class BoardService {
//
//    private final BoardRepository boardRepository;
//
//    @PreAuthorize("hasAuthority(T(com.company.demotrello.enums.Permissions).ROLE_READ)")
//    public List<BoardDTO> getAll() {
//        List<BoardDTO> authRoles = authRoleRepository.findAll();
//        return authRoleMapper.toDTO(authRoles);
//    }
//}
