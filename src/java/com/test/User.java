package com.test;

import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author soft
 */

public class User {
    
    private int id;
    private String name;
    private String license;
    private String  address;
    private  Date expiryDate ;
    
    public User(int ID, String name, String license, String address , Date expiryDate)
    {
        this.id = ID;
        this.name = name;
        this.license = license;
        this.address = address;
        this.expiryDate = expiryDate ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Date getExpiryDate() {
        if(expiryDate == null){
            return new Date(1000-01-01);
        }
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    

    
}
