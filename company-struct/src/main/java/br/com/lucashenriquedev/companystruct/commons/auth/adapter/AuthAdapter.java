package br.com.lucashenriquedev.companystruct.commons.auth.adapter;

import br.com.lucashenriquedev.companystruct.commons.auth.controller.response.UserResponse;
import br.com.lucashenriquedev.companystruct.domains.users.model.User;

public class AuthAdapter {

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }


}
