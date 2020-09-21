package com.user.user.model;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.*;
import org.springframework.stereotype.*;
import com.user.user.model.role;  
//Tells spring boot this is a component 
@Component 
@Entity
@Table(name = "users")
public class user implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "user_sequence", schema = "user_sequence")
    @Column(name = "user_id")
    private int userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "pass_word")
    private String passWord;

    @Column(name  = "email")
    private String email;

    @Column(name = "phone_number")
    private String phonenumber;

    @Column(name = "home_add")
    private String hAddress;

    @Column(name = "home_city")
    private String hCity;

    @Column(name = "home_state")
    private String hState;

    @Column(name = "home_zip")
    private String hZip;

    @Column(name = "work_add")
    private String wAddress;

    @Column(name = "work_city" )
    private String wCity;

    @Column(name = "work_state")
    private String wState;

    @Column(name = "work_zip")
    private String wZip;

    @Column(name = "time_created")
    private Timestamp created;

    @ManyToMany
    @JoinTable(name = "user_role")
    private role role;


    public user() {
    }

    public user(int userId, String firstName, String lastName, String userName, String passWord, String email, String phonenumber, String hAddress, String hCity, String hState, String hZip, String wAddress, String wCity, String wState, String wZip, Timestamp created, role role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.phonenumber = phonenumber;
        this.hAddress = hAddress;
        this.hCity = hCity;
        this.hState = hState;
        this.hZip = hZip;
        this.wAddress = wAddress;
        this.wCity = wCity;
        this.wState = wState;
        this.wZip = wZip;
        this.created = created;
        this.role = role;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return this.phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getHAddress() {
        return this.hAddress;
    }

    public void setHAddress(String hAddress) {
        this.hAddress = hAddress;
    }

    public String getHCity() {
        return this.hCity;
    }

    public void setHCity(String hCity) {
        this.hCity = hCity;
    }

    public String getHState() {
        return this.hState;
    }

    public void setHState(String hState) {
        this.hState = hState;
    }

    public String getHZip() {
        return this.hZip;
    }

    public void setHZip(String hZip) {
        this.hZip = hZip;
    }

    public String getWAddress() {
        return this.wAddress;
    }

    public void setWAddress(String wAddress) {
        this.wAddress = wAddress;
    }

    public String getWCity() {
        return this.wCity;
    }

    public void setWCity(String wCity) {
        this.wCity = wCity;
    }

    public String getWState() {
        return this.wState;
    }

    public void setWState(String wState) {
        this.wState = wState;
    }

    public String getWZip() {
        return this.wZip;
    }

    public void setWZip(String wZip) {
        this.wZip = wZip;
    }

    public Timestamp getCreated() {
        return this.created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public role getRole() {
        return this.role;
    }

    public void setRole(role role) {
        this.role = role;
    }

    public user userId(int userId) {
        this.userId = userId;
        return this;
    }

    public user firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public user lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public user userName(String userName) {
        this.userName = userName;
        return this;
    }

    public user passWord(String passWord) {
        this.passWord = passWord;
        return this;
    }

    public user email(String email) {
        this.email = email;
        return this;
    }

    public user phonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }

    public user hAddress(String hAddress) {
        this.hAddress = hAddress;
        return this;
    }

    public user hCity(String hCity) {
        this.hCity = hCity;
        return this;
    }

    public user hState(String hState) {
        this.hState = hState;
        return this;
    }

    public user hZip(String hZip) {
        this.hZip = hZip;
        return this;
    }

    public user wAddress(String wAddress) {
        this.wAddress = wAddress;
        return this;
    }

    public user wCity(String wCity) {
        this.wCity = wCity;
        return this;
    }

    public user wState(String wState) {
        this.wState = wState;
        return this;
    }

    public user wZip(String wZip) {
        this.wZip = wZip;
        return this;
    }

    public user created(Timestamp created) {
        this.created = created;
        return this;
    }

    public user role(role role) {
        this.role = role;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof user)) {
            return false;
        }
        user user = (user) o;
        return userId == user.userId && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(userName, user.userName) && Objects.equals(passWord, user.passWord) && Objects.equals(email, user.email) && Objects.equals(phonenumber, user.phonenumber) && Objects.equals(hAddress, user.hAddress) && Objects.equals(hCity, user.hCity) && Objects.equals(hState, user.hState) && Objects.equals(hZip, user.hZip) && Objects.equals(wAddress, user.wAddress) && Objects.equals(wCity, user.wCity) && Objects.equals(wState, user.wState) && Objects.equals(wZip, user.wZip) && Objects.equals(created, user.created) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, userName, passWord, email, phonenumber, hAddress, hCity, hState, hZip, wAddress, wCity, wState, wZip, created, role);
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", userName='" + getUserName() + "'" +
            ", passWord='" + getPassWord() + "'" +
            ", email='" + getEmail() + "'" +
            ", phonenumber='" + getPhonenumber() + "'" +
            ", hAddress='" + getHAddress() + "'" +
            ", hCity='" + getHCity() + "'" +
            ", hState='" + getHState() + "'" +
            ", hZip='" + getHZip() + "'" +
            ", wAddress='" + getWAddress() + "'" +
            ", wCity='" + getWCity() + "'" +
            ", wState='" + getWState() + "'" +
            ", wZip='" + getWZip() + "'" +
            ", created='" + getCreated() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }

}
