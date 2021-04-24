package br.com.lucashenriquedev.companystruct.commons.auth.controller;

import br.com.lucashenriquedev.companystruct.commons.auth.adapter.AuthAdapter;
import br.com.lucashenriquedev.companystruct.commons.auth.controller.response.UserResponse;
import br.com.lucashenriquedev.companystruct.commons.auth.service.AuthService;
import br.com.lucashenriquedev.companystruct.commons.messages.constants.AuthMessages;
import br.com.lucashenriquedev.companystruct.config.exception.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/me")
    public UserResponse getCurrentUserDetails() {
        return authService.getCurrentUser()
                .map(AuthAdapter::from)
                .orElseThrow(() -> new ResourceNotFoundException(AuthMessages.USER_NOT_FOUND));
    }

}
