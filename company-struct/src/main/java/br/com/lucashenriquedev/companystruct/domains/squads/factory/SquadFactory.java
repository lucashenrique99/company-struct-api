package br.com.lucashenriquedev.companystruct.domains.squads.factory;

import br.com.lucashenriquedev.companystruct.domains.squads.model.Squad;

public class SquadFactory {

    public static Squad create(Long id) {
        if (id == null) {
            return null;
        }
        var squad = new Squad();
        squad.setId(id);

        return squad;
    }

}
