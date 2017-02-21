package se.test.server.persistance.jpa;


import se.test.server.model.Address;

import java.util.List;

public interface AddressDao extends AbstractDao<Address, Long>  {
    List<Address> getAll();
    Address hamtaAddress(String street);
    void rensaAllaAddresser();
}
