package com.example.helpdeskback.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.helpdeskback.config.JwtService;
import com.example.helpdeskback.entity.Agent;
import com.example.helpdeskback.enums.Role;
import com.example.helpdeskback.repository.AgentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final AgentRepository agentRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    // create new user (still dont have users but will make it as create new agent)
    public AuthenticationResponse register(RegisterRequest request) {
        var agent=Agent.builder()
        .agentName(request.getFullname())
        .agentEmail(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.AGNET)
        .build();
        agentRepository.save(agent);

        var jwtToken = jwtService.generateToken(agent);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build()
            ; 
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(), 
                request.getPassword()
            )
        );
        // if email & password correct generate a token and send it back:
        //to do later : ps : need to thro< right exceptio
        var agent = agentRepository.findByAgentEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(agent);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build()
            ; 
    }


}
