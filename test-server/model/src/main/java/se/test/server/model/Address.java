package se.test.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "address")
@NamedQueries({
        @NamedQuery(name = "Address.hamtaAlla", query = "SELECT f FROM se.test.server.model.Address f"),
        @NamedQuery(name = "Address.hamtaAddressFranStreet", query = "SELECT f FROM se.test.server.model.Address f where f.street = :street"),
        @NamedQuery(name = "Address.rensaAllaAddress", query = "DELETE FROM se.test.server.model.Address")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String SEPARATOR = ";";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "street")
    private String street;

    @Column(name="city")
    private String city;

    @Column(name="province")
    private String province;

    @Column(name="country")
    private String country;

    @Column(name="postcode")
    private String postcode;

    public Address(){

    }
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public Address setId(Integer id) {
        this.id = id;
        return this;
    }
    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }
    /**
     * @param street the street to set
     */
    public Address setStreet(String street) {
        this.street = street;
        return this;
    }
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    /**
     * @param city the city to set
     */
    public Address setCity(String city) {
        this.city = city;
        return this;
    }
    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }
    /**
     * @param province the province to set
     */
    public Address setProvince(String province) {
        this.province = province;
        return this;
    }
    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }
    /**
     * @param country the country to set
     */
    public Address setCountry(String country) {
        this.country = country;
        return this;
    }
    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }
    /**
     * @param postcode the postcode to set
     */
    public Address setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }
}
