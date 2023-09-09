/*
 * Created on 2023-08-29 ( 12:15:33 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.startsup.merchant.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * JPA entity class for "User"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="user", catalog="merchantdb" )
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="name", nullable=false, length=80)
    private String     name ;

    @Column(name="email", nullable=false, length=100)
    private String     email ;

    @Column(name="phone", nullable=false, length=20)
    private String     phone ;

    @Column(name="zone_id", nullable=false)
    private Integer    zoneId ;

    @Column(name="role", nullable=false, length=45)
    private String     role ;

    @Column(name="encrypted_pass", length=2147483647)
    private String     encryptedPass ;


    public void setListOfOrder(List<Order> listOfOrder) {
        this.listOfOrder = listOfOrder;
    }

    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="user")
    @JsonIgnore
    private List<Order> listOfOrder ; 


    /**
     * Constructor
     */
    public User() {
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

    public void setRole( String role ) {
        this.role = role ;
    }
    public String getRole() {
        return this.role;
    }

    public void setEncryptedPass( String encryptedPass ) {
        this.encryptedPass = encryptedPass ;
    }
    public String getEncryptedPass() {
        return this.encryptedPass;
    }

    //--- GETTERS FOR LINKS
    public List<Order> getListOfOrder() {
        return this.listOfOrder;
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
        sb.append(role);
        // attribute 'encryptedPass' not usable (type = String Long Text)
        return sb.toString(); 
    } 

}
