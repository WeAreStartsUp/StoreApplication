package com.startsup.main.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document("store")
public class Store {

    @Id
    private String id;

    private String name;

    private Address address;

    @DocumentReference
    private Zone zone;

    public Store(String name, com.startsup.main.models.Address address, Zone zone) {
        this.name = name;
        this.address = address;
        this.zone = zone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.startsup.main.models.Address getAddress() {
        return address;
    }

    public void setAddress(com.startsup.main.models.Address address) {
        this.address = address;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}
