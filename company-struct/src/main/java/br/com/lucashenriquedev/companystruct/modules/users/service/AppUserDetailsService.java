package br.com.lucashenriquedev.companystruct.modules.users.service;

import br.com.lucashenriquedev.companystruct.commons.messages.constants.CommonErrorMessages;
import br.com.lucashenriquedev.companystruct.modules.users.factory.SystemUserFactory;
import br.com.lucashenriquedev.companystruct.modules.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService users;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> optionalUser = users.handleLoginCheck(login);
        User user = optionalUser.orElseThrow(() -> new UsernameNotFoundException(CommonErrorMessages.INVALID_USER_OR_PASSWORD));
        return SystemUserFactory.create(user);
    }

}
