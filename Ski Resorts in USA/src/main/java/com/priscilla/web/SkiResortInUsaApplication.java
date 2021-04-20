package com.priscilla.web;

import com.priscilla.web.entity.enumerate.UserRole;
import com.priscilla.web.entity.user.User;
import com.priscilla.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication
public class SkiResortInUsaApplication {

	public static void main(String[] args) {

		SpringApplication.run(SkiResortInUsaApplication.class, args);
	}

}
