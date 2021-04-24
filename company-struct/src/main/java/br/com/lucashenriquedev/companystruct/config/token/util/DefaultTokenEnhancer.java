package br.com.lucashenriquedev.companystruct.config.token.util;

import br.com.lucashenriquedev.companystruct.commons.model.SystemUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DefaultTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        SystemUser systemUser = (SystemUser) authentication.getPrincipal();
        Map<String, Object> addInfo = new HashMap<>();

        addInfo.put("user", Collections.singletonMap("id", systemUser.getUser().getId()));

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);
        return accessToken;
    }

}
