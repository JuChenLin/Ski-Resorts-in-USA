package com.priscilla.web.service;

import com.priscilla.web.SocialLoginUserInfo.GoogleUserInfo;
import com.priscilla.web.entity.user.User;
import com.priscilla.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomOidcUserService extends OidcUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);

        try {
            return processOidcUser(userRequest, oidcUser);
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OidcUser processOidcUser(OidcUserRequest userRequest, OidcUser oidcUser) {
        GoogleUserInfo googleUserInfo = new GoogleUserInfo(oidcUser.getAttributes());
//        System.out.println("CustomOidcUserService.processOidcUser ---> googleUserInfo: " + googleUserInfo);

        Optional<User> userOptional = userRepository.findById(googleUserInfo.getId());
//        System.out.println("CustomOidcUserService.processOidcUser ---> userOptional: " + userOptional);

        if (!userOptional.isPresent()) {
            User user = new User(googleUserInfo.getId(), googleUserInfo.getEmail(), googleUserInfo.getName(), "SOC");

            System.out.println("CustomOidcUserService.processOidcUser ---> user: " + user);

            // set other needed data
            userRepository.save(user);
        }

        return oidcUser;
    }
}
