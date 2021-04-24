package br.com.lucashenriquedev.companystruct.modules.squads.service;

import br.com.lucashenriquedev.companystruct.commons.service.AbstractCRUDService;
import br.com.lucashenriquedev.companystruct.modules.squads.model.Squad;
import br.com.lucashenriquedev.companystruct.modules.squads.repository.SquadRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SquadService extends AbstractCRUDService<Squad, SquadRepository> {

    @Override
    public List<Squad> findAll() {
        return repository.findAll(Sort.by("name"));
    }

    public Optional<Squad> update(Long id, Squad squad) {
        return repository.findById(id)
                .map(saved -> {
                    saved.setName(saved.getName());
                    saved.setProjectCode(saved.getProjectCode());
                    saved.setNotes(squad.getNotes());

                    return repository.save(saved);
                });
    }
}
