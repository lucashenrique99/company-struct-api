package br.com.lucashenriquedev.companystruct.modules.squads.controller;

import br.com.lucashenriquedev.companystruct.modules.squads.service.SquadServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/squads")
public class SquadController {

    @Autowired
    private SquadServiceFacade service;

    /**
     * criar squad
     * editar caracteristicas squad
     * adicionar membros na squad
     * editar um membro da squad
     * remover um membro da squad
     * remover squad
     */

}
