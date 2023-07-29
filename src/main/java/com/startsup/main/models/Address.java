package com.startsup.main.models;

import org.springframework.data.mongodb.core.mapping.DocumentReference;

public class Address {
    private String firstLine;
    private String secondLine;
    private String city;
    private String state;
    private String country;
    private String pinCode;


    public Address(String firstLine, String secondLine, String city, String state, String country, String pinCode) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }

//    public Address(Builder builder) {
//        this.firstLine = builder.firstLine;
//        this.secondLine = builder.secondLine;
//        this.city = builder.city;
//        this.state = builder.state;
//        this.country = builder.country;
//        this.pinCode = builder.pinCode;
//        this.zone = builder.zone;
//    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

//    public static class Builder {
//        private String firstLine;
//        private String secondLine;
//        private String city;
//        private String state;
//        private String country;
//        private String pinCode;
//
//        private Zone zone;
//
//        public Builder setZone(Zone zone) {
//            this.zone = zone;
//            return this;
//        }
//
//        public static Builder newInstance()
//        {
//            return new Builder();
//        }
//
//        private Builder() {}
//
//        public Address build()
//        {
//            return new Address(this);
//        }
//
//        public Builder setFirstLine(String firstLine) {
//            this.firstLine = firstLine;
//            return this;
//        }
//
//        public Builder setSecondLine(String secondLine) {
//            this.secondLine = secondLine;
//            return this;
//        }
//
//        public Builder setCity(String city) {
//            this.city = city;
//            return this;
//        }
//
//        public Builder setState(String state) {
//            this.state = state;
//            return this;
//        }
//
//        public Builder setCountry(String country) {
//            this.country = country;
//            return this;
//        }
//
//        public Builder setPinCode(String pinCode) {
//            this.pinCode = pinCode;
//            return this;
//        }
//    }
}
