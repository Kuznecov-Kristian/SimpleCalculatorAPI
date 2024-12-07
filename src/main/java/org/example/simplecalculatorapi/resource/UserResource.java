package org.example.simplecalculatorapi.resource;

import org.example.simplecalculatorapi.configuration.JwtUtil;
import org.example.simplecalculatorapi.dto.AuthenticationRequestDto;
import org.example.simplecalculatorapi.entity.User;
import org.example.simplecalculatorapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());

        User save = userService.save(user);
        return ResponseEntity.ok(save);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody AuthenticationRequestDto authenticationRequest) {
        UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.username());
        String jwt = jwtUtil.generateToken(userDetails);
        return jwt;
    }
}