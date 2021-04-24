package br.com.lucashenriquedev.companystruct.modules.users.factory;

import br.com.lucashenriquedev.companystruct.commons.model.SystemUser;
import br.com.lucashenriquedev.companystruct.modules.users.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

public class SystemUserFactory {

    public static UserDetails create(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getPermissions().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getName())));

        return new SystemUser(user, authorities);
    }

}
