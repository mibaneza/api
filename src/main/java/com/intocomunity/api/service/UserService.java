package com.intocomunity.api.service;

import com.intocomunity.api.repository.UserRepository;
import com.intocomunity.api.service.exception.MensajeException;
import com.intocomunity.api.service.exception.NotFountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intocomunity.api.service.dto.UserDTO;
@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpenService.class);
    private static final String ERROR = "NOT_FOUND";
    private static final String CODE = "SNOT-404-1";

    @Autowired
    private  UserRepository userRepository;

    public UserDTO getUser(String username) throws MensajeException {

        return new UserDTO(userRepository.findByUsername(username).orElseThrow(() ->  new NotFountException(CODE, ERROR)));
    }
}
