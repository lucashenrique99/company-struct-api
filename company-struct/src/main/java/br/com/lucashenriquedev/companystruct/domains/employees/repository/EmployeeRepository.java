package br.com.lucashenriquedev.companystruct.domains.employees.repository;

import br.com.lucashenriquedev.companystruct.domains.employees.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.isActive = TRUE")
    List<Employee> findAllActives();

    @Query("SELECT e FROM Employee e WHERE e.isActive = TRUE AND " +
            "MONTH(e.birthDate) = :month")
    List<Employee> findAllActivesByBirthDateInMonth(Integer month, Pageable pageable);

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByCpf(String cpf);

}
