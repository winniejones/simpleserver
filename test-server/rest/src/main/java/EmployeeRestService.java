import facade.Facade;
import se.test.server.model.Address;
import se.test.server.model.Employee;
import se.test.server.persistance.jpa.AddressDao;
import se.test.server.persistance.jpa.EmployeeDao;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/employee")
public class EmployeeRestService {

    @Inject
    private AddressDao addressDao;

    @GET
    @Path("/json")
    @Produces({"application/json"})
    public Response getHelloWorldJSON() {
        List<Address> list = addressDao.getAll();
        return Response.status(Response.Status.OK).entity(list).build();
    }
}
