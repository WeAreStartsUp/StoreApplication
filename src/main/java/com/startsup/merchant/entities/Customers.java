/*
 * Created on 2023-08-28 ( 12:18:30 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.startsup.merchant.entities;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * JPA entity class for "Customers"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="customers", catalog="merchantdb" )
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="name", nullable=false, length=100)
    private String     name ;

    @Column(name="email", length=200)
    private String     email ;

    @Column(name="phone", nullable=false, length=20)
    private String     phone ;

    @Column(name="zone_id", nullable=false)
    private Integer    zoneId ;

    @Column(name="address_first_line", nullable=false, length=100)
    private String     addressFirstLine ;

    @Column(name="address_second_line", length=100)
    private String     addressSecondLine ;

    @Column(name="city", nullable=false, length=45)
    private String     city ;

    @Column(name="state", nullable=false, length=45)
    private String     state ;

    @Column(name="country", nullable=false, length=45)
    private String     country ;

    @Column(name="additional_details", length=1073741824)
    private String     additionalDetails ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="zone_id", referencedColumnName="id", insertable=false, updatable=false)
    private Zones      zones ; 


    /**
     * Constructor
     */
    public Customers() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    public void setName( String name ) {
        this.name = name ;
    }
    public String getName() {
        return this.name;
    }

    public void setEmail( String email ) {
        this.email = email ;
    }
    public String getEmail() {
        return this.email;
    }

    public void setPhone( String phone ) {
        this.phone = phone ;
    }
    public String getPhone() {
        return this.phone;
    }

    public void setZoneId( Integer zoneId ) {
        this.zoneId = zoneId ;
    }
    public Integer getZoneId() {
        return this.zoneId;
    }

    public void setAddressFirstLine( String addressFirstLine ) {
        this.addressFirstLine = addressFirstLine ;
    }
    public String getAddressFirstLine() {
        return this.addressFirstLine;
    }

    public void setAddressSecondLine( String addressSecondLine ) {
        this.addressSecondLine = addressSecondLine ;
    }
    public String getAddressSecondLine() {
        return this.addressSecondLine;
    }

    public void setCity( String city ) {
        this.city = city ;
    }
    public String getCity() {
        return this.city;
    }

    public void setState( String state ) {
        this.state = state ;
    }
    public String getState() {
        return this.state;
    }

    public void setCountry( String country ) {
        this.country = country ;
    }
    public String getCountry() {
        return this.country;
    }

    public void setAdditionalDetails( String additionalDetails ) {
        this.additionalDetails = additionalDetails ;
    }
    public String getAdditionalDetails() {
        return this.additionalDetails;
    }

    //--- GETTERS FOR LINKS
    public Zones getZones() {
        return this.zones;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(email);
        sb.append("|");
        sb.append(phone);
        sb.append("|");
        sb.append(zoneId);
        sb.append("|");
        sb.append(addressFirstLine);
        sb.append("|");
        sb.append(addressSecondLine);
        sb.append("|");
        sb.append(city);
        sb.append("|");
        sb.append(state);
        sb.append("|");
        sb.append(country);
        // attribute 'additionalDetails' not usable (type = String Long Text)
        return sb.toString(); 
    } 

}
