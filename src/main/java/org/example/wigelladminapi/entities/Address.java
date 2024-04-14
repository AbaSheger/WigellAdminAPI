package org.example.wigelladminapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "street", length = 50, nullable = false)
    private String street;

    @Column(name = "postal_code", length = 50, nullable = false)

    private String postalCode;

    @Column(name = "city", length = 50, nullable = false)
    private String city;


    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("address")
    private Set<Member> members = new HashSet<>();

    public Address() {
    }

    public Address(long id, String street, String postalCode, String city, Set<Member> member) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.members = member;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }
}
