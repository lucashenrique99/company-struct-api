package br.com.lucashenriquedev.companystruct.domains.communities.factory;

import br.com.lucashenriquedev.companystruct.domains.communities.model.Community;

public class CommunityFactory {

    public static Community create(Long id) {
        if (id == null) {
            return null;
        }

        var community = new Community();
        community.setId(id);

        return community;
    }

}
