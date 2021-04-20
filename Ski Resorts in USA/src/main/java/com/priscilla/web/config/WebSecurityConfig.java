package com.priscilla.web.config;

import com.priscilla.web.service.CustomOidcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.endpoint.NimbusAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_URL = "/login";
    private static final String LOGOUT_URL = "/logout";
    private static final String LOGOUT_SUCCESS_URL = "/ski-resorts";

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
    @Autowired
    private CustomOidcUserService customOidcUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        super.configure(http);
//        http.authorizeRequests(
//                a -> a.antMatchers("/", "/oauth_login","/error", "/webjars/**").permitAll()
//                        .anyRequest().authenticated()
//                )
////                .exceptionHandling(e -> e
////                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
////                )
//                .oauth2Login().loginPage("/oauth_login")
//                .logout(l -> l
//                          .logoutSuccessUrl("/").permitAll()
//                  .csrf(c -> c
//                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                  )
//        )


        http.authorizeRequests()
                .antMatchers("/", "/login","/error", "/webjars/**")
                    .permitAll()
                .antMatchers(HttpMethod.GET, "/my-favorites/**")
                    .authenticated()
                .and()
                    .oauth2Login().loginPage(LOGIN_URL).defaultSuccessUrl("/ski-resorts").failureUrl("/loginFailure").userInfoEndpoint().oidcUserService(customOidcUserService);
//                .and()
//                    .logout().logoutSuccessUrl("/").permitAll()
//                .and()
//                    .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

        http.logout().logoutSuccessHandler(oidcLogoutSuccessHandler()).invalidateHttpSession(true).clearAuthentication(true).deleteCookies("JSESSIONID");
    }


    private LogoutSuccessHandler oidcLogoutSuccessHandler() {
        OidcClientInitiatedLogoutSuccessHandler successHandler = new OidcClientInitiatedLogoutSuccessHandler(this.clientRegistrationRepository);
        successHandler.setPostLogoutRedirectUri("http://localhost:8082/index");

        return successHandler;
    }
}
