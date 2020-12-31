package com.intocomunity.api.service;

import com.intocomunity.api.security.DiscordAPI;
import com.intocomunity.api.security.DiscordOAuth;
import com.intocomunity.api.security.model.User;
import com.intocomunity.api.service.exception.MensajeException;
import com.intocomunity.api.service.exception.NotFountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DiscordService {

    @Value("${intocablesrp.app.discord.clientID}")
    private String clientID;
    @Value("${intocablesrp.app.discord.clientSecret}")
    private String clientSecret;

    private static final Logger LOGGER = LoggerFactory.getLogger(DiscordService.class);
    private static final String ERROR = "NOT_FOUND";
    private static final String CODE = "SNOT-404-1";
    private static final  String scope[] = {"indentify"};
    private User user;
    public User getUserDiscord(String accessToken) throws MensajeException {
        DiscordOAuth oauthHandler = new DiscordOAuth(clientID, clientSecret,  scope);
        DiscordAPI api = new DiscordAPI(accessToken);
        try {
            user = api.fetchUser();
        }catch (IOException e){
            LOGGER.error(ERROR, e);
             throw new NotFountException(CODE, ERROR);
        }
        return  user ;
    }

}
