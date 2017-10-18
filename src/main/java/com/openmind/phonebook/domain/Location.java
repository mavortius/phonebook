package com.openmind.phonebook.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    private String id;
    private String name;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String mainPhone;
    private String mainFax;

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public Location(String id, String name, String address1, String address2,
                    String city, String state, String zip, String country, String mainPhone, String mainFax) {
        this.id = id;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.mainPhone = mainPhone;
        this.mainFax = mainFax;
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getMainFax() {
        return mainFax;
    }

    public void setMainFax(String mainFax) {
        this.mainFax = mainFax;
    }
}
