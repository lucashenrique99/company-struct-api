package br.com.lucashenriquedev.companystruct.domains.users.repository;

import br.com.lucashenriquedev.companystruct.domains.users.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {
}
