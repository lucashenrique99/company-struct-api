package br.com.lucashenriquedev.companystruct.commons.service;

import br.com.lucashenriquedev.companystruct.commons.model.AbstractModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractCRUDService<Model extends AbstractModel, Repository extends JpaRepository<Model, Long>> {

    @Autowired
    protected Repository repository;

    public Optional<Model> insert(Model model) {
        return Optional.of(repository.save(model));
    }

    public Optional<Model> findById(Long id) {
        return repository.findById(id);
    }

    public List<Model> findAll() {
        return repository.findAll();
    }

    public List<Model> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    public Page<Model> findAll(Integer page, Integer pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize));
    }

    public Page<Model> findAll(Integer page, Integer pageSize, Sort sort) {
        return repository.findAll(PageRequest.of(page, pageSize, sort));
    }

}
