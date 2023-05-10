package com.librarybooks.models;


import javax.persistence.*;

@Entity
@Table(name="member_information")
public class UserInformation {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String address;
    private double contact;

    public UserInformation() {
    }

    public UserInformation(int id, String username, String address, double contact) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getContact() {
        return contact;
    }

    public void setContact(double contact) {
        this.contact = contact;
    }
}
