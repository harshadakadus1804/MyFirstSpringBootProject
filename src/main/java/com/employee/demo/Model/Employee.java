package com.employee.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name= "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "Id")
    Integer Id ;

    @Column(name= "firstname")
    String FirstName;

    @Column(name= "lastname")
    String LastName;

    @Column(name= "Email")
    String Email;

    @Column(name= "Phone")
    Integer Phone;

    @Column(name= "City")
    String City;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getPhone() {
        return Phone;
    }

    public void setPhone(Integer phone) {
        Phone = phone;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}