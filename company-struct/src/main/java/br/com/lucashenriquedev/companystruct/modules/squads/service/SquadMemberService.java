package br.com.lucashenriquedev.companystruct.modules.squads.service;

import br.com.lucashenriquedev.companystruct.modules.squads.repository.SquadMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SquadMemberService {

    @Autowired
    private SquadMemberRepository repository;

}
