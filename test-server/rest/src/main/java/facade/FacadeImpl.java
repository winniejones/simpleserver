package facade;

import se.test.server.model.Employee;
import se.test.server.persistance.jpa.EmployeeDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


public class FacadeImpl implements Facade{

    @Inject
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> hamtaAllt(){
        List<Employee> listEmployee = employeeDao.findAll();
        if(listEmployee.isEmpty()) listEmployee = new ArrayList<>();
        return listEmployee;
    }
}
