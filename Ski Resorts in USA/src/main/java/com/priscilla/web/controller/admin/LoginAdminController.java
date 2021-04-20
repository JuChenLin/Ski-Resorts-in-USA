package com.priscilla.web.controller.admin;

//import com.priscilla.web.repository.UserRepository;

import com.priscilla.web.concrete.AddModelAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class LoginAdminController {

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
    @Autowired
    private AddModelAttributes addModelAttributes;

    private final static String authorizationRequestBaseUri = "oauth2/authorization";
    Map<String, String> oauth2AuthenticationUrls = new HashMap<>();

    @GetMapping("/login")
    public String getLoginPage(@AuthenticationPrincipal OAuth2User principal, Model model) { ;
        Iterable<ClientRegistration> clientRegistrations = null;

        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository).as(Iterable.class);
        if (type != ResolvableType.NONE && ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
            clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
        }

        assert clientRegistrations != null;
        clientRegistrations.forEach(registration ->
                oauth2AuthenticationUrls.put(registration.getClientName(), authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
        model.addAttribute("urls", oauth2AuthenticationUrls);

//        if (principal != null) {
//            System.out.println("Login User:" + principal);
//            model.addAttribute("user", principal.getAttribute("name"));
//        }

        addModelAttributes.modelOAuth2User(principal, model);

        return "/login/oauth";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess(@AuthenticationPrincipal OAuth2User principal, Model model) {

        System.out.println("Login User:" + principal);

//        if (principal != null) {
//            System.out.println("Login User:" + principal);
////            Map<String, Object> map = Collections.singletonMap("name", principal.getAttribute("name"));
//            model.addAttribute("name", principal.getAttribute("name"));
//            model.addAttribute("email", principal.getAttribute("email"));
//        }

        addModelAttributes.modelOAuth2User(principal, model);

        return "redirect:/ski-resort";
//        return "user";
    }


//    @GetMapping("/loginSuccess")
//    public String loginSuccess(@SocialUser User user) {
//        log.info("성공");
//
//        return "login";
//    }
//
//    @GetMapping("/loginFailure")
//    public String loginFailure() {
//        log.info("실패");
//        return "login";
//    }
}
