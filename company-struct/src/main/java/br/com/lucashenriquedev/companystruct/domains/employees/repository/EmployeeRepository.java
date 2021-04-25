package br.com.lucashenriquedev.companystruct.domains.employees.repository;

import br.com.lucashenriquedev.companystruct.domains.employees.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.isActive = TRUE")
    List<Employee> findAllActives();

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByCpf(String cpf);

}
