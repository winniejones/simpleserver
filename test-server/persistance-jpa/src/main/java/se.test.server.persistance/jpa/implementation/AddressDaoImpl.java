package se.test.server.persistance.jpa.implementation;

import se.test.server.model.Address;
import se.test.server.persistance.jpa.AddressDao;

import javax.enterprise.inject.Default;
import javax.persistence.Query;
import java.util.List;

@Default
public class AddressDaoImpl extends AbstractDaoImpl<Address, Long> implements AddressDao {
    public AddressDaoImpl() {
        super(Address.class);
    }

    public List<Address> getAll(){
        List<Address> allAddresses = null;
        try{
            allAddresses = (List<Address>) getEm().createNamedQuery("Address.hamtaAlla").getResultList();
            System.out.println("tabell lista:"+allAddresses);
        }catch (Exception e){
            System.err.println(e);
        }
        return allAddresses;
    }

    public Address hamtaAddress(String street) {
        Address address = null;

        try {
            address = (Address) getEm().createNamedQuery("Address.hamtaAddressFranStreet").setParameter("street",street).getSingleResult();
        } catch(Exception e) {
            System.err.print("Hittade ingen address med det gatunamnet");
        }
        return address;
    }

    public void rensaAllaAddresser() {

        try {
            getEm().createNamedQuery("Address.rensaAllaAddress").executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
