package br.com.lucashenriquedev.companystruct.modules.employees.factory;


import br.com.lucashenriquedev.companystruct.modules.employees.model.Employee;

public class EmployeeFactory {

    public static Employee create(Long id) {
        if (id == null) {
            return null;
        }
        Employee e = new Employee();
        e.setId(id);
        return e;
    }


}
