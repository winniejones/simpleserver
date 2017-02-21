package facade;

import se.test.server.model.Employee;

import javax.ejb.Remote;
import java.util.List;


public interface Facade {

    List<Employee> hamtaAllt();
}
