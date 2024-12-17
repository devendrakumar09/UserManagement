package com.userManagement.UserManagement.Entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "user_profile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 10, nullable = false)
    private String contact;

    @Column(length = 100, nullable = false)
    private String city;

    @Column(length = 6, nullable = false)
    private String zip_code;

    public ProfileEntity() {
    }

    public ProfileEntity(String contact, String city, String zip_code) {
        this.contact = contact;
        this.city = city;
        this.zip_code = zip_code;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }
}
