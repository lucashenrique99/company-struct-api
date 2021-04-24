package br.com.lucashenriquedev.companystruct.modules.squads.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SquadServiceFacade {

    @Autowired
    private SquadService squadService;

    @Autowired
    private SquadMemberService squadMemberService;


}
