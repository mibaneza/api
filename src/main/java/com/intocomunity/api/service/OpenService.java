package com.intocomunity.api.service;

import com.intocomunity.api.dominio.ERole;
import com.intocomunity.api.dominio.Role;
import com.intocomunity.api.repository.RoleRepository;
import com.intocomunity.api.repository.UserRepository;
import com.intocomunity.api.security.jwt.JwtUtils;
import com.intocomunity.api.security.model.User;
import com.intocomunity.api.service.dto.JwtDTO;
import com.intocomunity.api.service.dto.LoginDTO;
import com.intocomunity.api.service.dto.UserDTO;
import com.intocomunity.api.service.exception.MensajeException;
import com.intocomunity.api.service.exception.NotFountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OpenService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpenService.class);
    private static final String ERROR = "NOT_FOUND";
    private static final String CODE = "SNOT-404-1";

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    private final JwtUtils jwtUtils;

    private final DiscordService discordService;

    public OpenService(
            AuthenticationManager authenticationManager,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            RoleRepository roleRepository,
            JwtUtils jwtUtils,
            DiscordService discordService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.jwtUtils = jwtUtils;
        this.discordService = discordService;
    }


    public LoginDTO openService(String accessToken) throws MensajeException {
       User userDiscord =  discordService.getUserDiscord(accessToken);

        if(!userDiscord.getVerified()){
            throw new RuntimeException("Error: Mail no verificado.");
        }

        if (!userRepository.existsByUsername(userDiscord.getId()) ){
            registerUser(userDiscord);
        }
        UserDTO userDTO = getUser(userDiscord.getId());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDiscord.getId(),
                        userDiscord.getEmail()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        return new LoginDTO(userDTO, new JwtDTO(jwt));
    }


    public void registerUser(User userDiscord) throws MensajeException {
        com.intocomunity.api.dominio.User userDominio = new com.intocomunity.api.dominio.User(
                userDiscord.getId(), userDiscord.getAvatar(),userDiscord.getVerified(),
                userDiscord.getEmail(),userDiscord.getUsername(),userDiscord.getFullUsername()
        );
        userDominio.setPassword(passwordEncoder.encode(userDiscord.getEmail()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);

        userDominio.setRoles(roles);
        try {
            userRepository.save(userDominio);
        } catch (final Exception e) {
            LOGGER.error(ERROR, e);
            throw new NotFountException(CODE, ERROR);
        }
         new RuntimeException("se agrego");
    }

    public UserDTO getUser(String username) throws MensajeException {

        return new UserDTO(userRepository.findByUsername(username).orElseThrow(() ->  new NotFountException(CODE, ERROR)));
    }
}
