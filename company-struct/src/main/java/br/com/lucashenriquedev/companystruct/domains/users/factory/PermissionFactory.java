package br.com.lucashenriquedev.companystruct.domains.users.factory;

import br.com.lucashenriquedev.companystruct.domains.users.model.Permission;

public class PermissionFactory {

    public static Permission create(String name) {
        return Permission.builder()
                .name(name)
                .build();
    }

    public static Permission createRoot() {
        return create("ROLE_ROOT");
    }


}
