package se.test.server.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity(name = "employee")
@NamedQueries({
        @NamedQuery(name = "Employee.hamtaAllaEmployee", query = "SELECT f FROM se.test.server.model.Employee f"),
        @NamedQuery(name = "Employee.hamtaEmployeeFranNamn", query = "SELECT f FROM se.test.server.model.Employee f where f.firstName = :firstName"),
        @NamedQuery(name = "Employee.rensaAllaEmployees", query = "DELETE FROM se.test.server.model.Employee")})
public class Employee implements Serializable{

    private static final long serialVersionUID = 1L;

    private static final String SEPARATOR = ";";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "salary")
    private double salary;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate", nullable = true)
    private Date endDate;

    @ManyToOne
    private Employee managerId;

    @OneToOne
    private Address addressId;

    public Employee(){

    }
}
