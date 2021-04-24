package br.com.lucashenriquedev.companystruct.modules.users.repository;

import br.com.lucashenriquedev.companystruct.modules.users.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {
}
