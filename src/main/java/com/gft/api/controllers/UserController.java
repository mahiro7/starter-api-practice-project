package com.gft.api.controllers;

import com.gft.api.dto.user.UserMapper;
import com.gft.api.dto.user.UserQueryDTO;
import com.gft.api.dto.user.UserRegisterDTO;
import com.gft.api.entities.User;
import com.gft.api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<UserQueryDTO> saveUser(@RequestBody UserRegisterDTO dto) {
        User user = userService.saveUser(UserMapper.fromDTO(dto));

        return ResponseEntity.ok(UserMapper.fromEntity(user));
    }
}
