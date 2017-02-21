package se.test.server.persistance.jpa.implementation;


import se.test.server.model.Address;
import se.test.server.model.Employee;
import se.test.server.persistance.jpa.AddressDao;
import se.test.server.persistance.jpa.EmployeeDao;

import javax.enterprise.inject.Default;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Default
public class EmployeeDaoImpl  extends AbstractDaoImpl<Employee, Long> implements EmployeeDao {
    public EmployeeDaoImpl(){
        super(Employee.class);
    }

    public Employee hamtaEmployee(String firstName){
        Employee employee= null;
        try{
            employee = (Employee) getEm().createNamedQuery("Employee.hamtaEmployeeFranNamn").setParameter("firstName",firstName).getSingleResult();
        }catch (Exception e){
            System.err.println(e);
        }
        return employee;
    }
    public List<Employee> getAll(){
        List<Employee> list = null;
        try{
            //list = (List<Employee>) getEm().createNamedQuery("Employee.hamtaAllaEmployee").getResultList();
            Query query = getEm().createQuery("SELECT c FROM employee c");
            list = query.getResultList();
            System.out.println("tabell lista:"+list);
        }catch (Exception e){
            System.err.println(e);
        }
        return list.isEmpty() ? new ArrayList<Employee>() : list;
    }

    public void rensaAllaEmployees(){
        try {
            getEm().createNamedQuery("Employee.rensaAllaEmployees").executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
