package br.com.lucashenriquedev.companystruct.modules.users.repository;

import br.com.lucashenriquedev.companystruct.modules.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AbstractUserRepository<T extends User> extends JpaRepository<T, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.permissions IS NOT EMPTY")
    Optional<T> handleLoginCheck(String email);

    Optional<T> findByEmail(String email);
}
