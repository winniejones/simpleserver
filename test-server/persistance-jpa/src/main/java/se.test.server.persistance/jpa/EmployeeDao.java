package se.test.server.persistance.jpa;


import se.test.server.model.Employee;

import java.util.List;

public interface EmployeeDao extends AbstractDao<Employee, Long> {
    Employee hamtaEmployee(String firstName);
    List<Employee> getAll();
    void rensaAllaEmployees();
}
