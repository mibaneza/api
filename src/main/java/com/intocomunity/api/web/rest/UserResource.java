package com.intocomunity.api.web.rest;


import com.intocomunity.api.security.model.*;
import com.intocomunity.api.security.DiscordAPI;
import com.intocomunity.api.security.DiscordOAuth;
import com.intocomunity.api.service.OpenService;
import com.intocomunity.api.service.UserService;
import com.intocomunity.api.service.dto.JwtDTO;
import com.intocomunity.api.service.dto.LoginDTO;
import com.intocomunity.api.service.dto.UserDTO;
import com.intocomunity.api.service.exception.MensajeException;
import com.intocomunity.api.web.rest.response.MensajeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;


@RestController
@RequestMapping("/api/")
public class UserResource  {
    private static final String SUCCES = "Succes";
    private static final String OK = "OK";

    @Autowired
    OpenService openService;

    @Autowired
    UserService userService;
    @PostMapping("web/open")
    public MensajeResponse<LoginDTO> openPost(@RequestBody String accessToken) throws MensajeException {
        return new MensajeResponse<>(SUCCES, String.valueOf(HttpStatus.OK), OK,
                openService.openService(accessToken));
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("security/userInfo")
    public MensajeResponse<UserDTO> userInfo(Principal principal) throws MensajeException {
        return new MensajeResponse<>(SUCCES, String.valueOf(HttpStatus.OK), OK,
                userService.getUser(principal.getName()) );
    }



}
