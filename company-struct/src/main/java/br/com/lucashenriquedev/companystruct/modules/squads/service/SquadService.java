package br.com.lucashenriquedev.companystruct.modules.squads.service;

import br.com.lucashenriquedev.companystruct.modules.squads.repository.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SquadService {

    @Autowired
    private SquadRepository repository;

}
