package br.com.lucashenriquedev.companystruct.commons.auth.service;

import br.com.lucashenriquedev.companystruct.modules.users.model.User;
import br.com.lucashenriquedev.companystruct.modules.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public Optional<? extends User> getCurrentUser() {
        return userService.getCurrentLoggedUser();
    }
}
