package br.com.lucashenriquedev.companystruct.modules.users.service;

import br.com.lucashenriquedev.companystruct.modules.users.model.Permission;
import br.com.lucashenriquedev.companystruct.modules.users.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermissionsService {

    @Autowired
    private PermissionRepository permissionRepository;

    public Optional<Permission> findById(String id) {
        return permissionRepository.findById(id);
    }

}
