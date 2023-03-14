package com.procemetrix.authservice.controller;

import com.procemetrix.authservice.dto.AuthUserDto;
import com.procemetrix.authservice.dto.NewUserDto;
import com.procemetrix.authservice.dto.RequestDto;
import com.procemetrix.authservice.dto.TokenDto;
import com.procemetrix.authservice.entity.AuthUser;
import com.procemetrix.authservice.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    AuthUserService authUserService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody AuthUserDto dto) {
        TokenDto tokenDto = authUserService.login(dto);
        if (tokenDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/validate")
    public ResponseEntity<TokenDto> validate(@RequestParam String token, @RequestBody RequestDto dto) {
        TokenDto tokenDto = authUserService.validate(token, dto);
        if (tokenDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/create")
    public ResponseEntity<AuthUser> create(@RequestBody NewUserDto dto) {
        AuthUser authUser = authUserService.save(dto);
        if (authUser == null)
            return ResponseEntity.badRequest().build();
        return  ResponseEntity.ok(authUser);
    }
}
