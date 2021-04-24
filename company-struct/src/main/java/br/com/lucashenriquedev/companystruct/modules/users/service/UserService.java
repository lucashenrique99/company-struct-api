package br.com.lucashenriquedev.companystruct.modules.users.service;

import br.com.lucashenriquedev.companystruct.modules.users.model.User;
import br.com.lucashenriquedev.companystruct.modules.users.repository.AbstractUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private AbstractUserRepository<User> repository;

    @Autowired
    private AuthUtilsService authUtilsService;


    public Optional<User> handleLoginCheck(String email) {
        return repository.handleLoginCheck(email);
    }

    public Optional<User> getCurrentLoggedUser() {
        return this.authUtilsService.getCurrentUsername()
                .flatMap(username -> this.repository.findByEmail(username));
    }
}
