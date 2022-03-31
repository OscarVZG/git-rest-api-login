package com.example.RestLOgin.ApiRestLoginTest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
@Entity
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERSON")
    @SequenceGenerator(sequenceName = "SQ_PERSON", allocationSize = 1, name = "SQ_PERSON")
    private int id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    @Size(min = 10, message = "last name debe tener al menos ")
    private String lastName;
    @Email(message = "user.email.mask")
    private String email;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Person create(String firstName, String lastName, String email, String address) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);
        person.setAddress(address);
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", Nombre ='" + firstName + '\'' +
                ", Apellido='" + lastName + '\'' +
                ", Correo ='" + lastName + '\'' +
                ", Dirección='" + address + '\'' +
                '}';
    }

}
