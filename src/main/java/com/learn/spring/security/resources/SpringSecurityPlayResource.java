package com.learn.spring.security.resources;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SpringSecurityPlayResource {

    @GetMapping("/csrf-token")
    public CsrfToken retriveCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
        //The attribute _csrf can be seen on inspecting(F12) the login page or logOut page generated 
        //by spring security.
    }

}
