package com.user.user.model;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;


// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

import com.user.user.model.role;
//Tells spring boot this is a component 


@Entity
@Table(name = "tempusers")
public class user{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "user_sequence", schema = "user_sequence")
    @Column(name = "user_id")
    private int userId;

    @Valid
    @NotBlank
    @Size(min = 30)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "user_name")
    private String userName;

    @NotBlank
    @Size(min = 4)
    @Column(name = "pass_word")
    private String passWord;

    @Email
    @NotBlank
    @Column(name = "email")
    private String email;

    @Valid
    @NotBlank
    @Column(name = "phonenumber")
    private String phonenumber;

    @Valid
    @NotBlank
    @Column(name = "homeadd")
    private String hAddress;

    @Valid
    @NotBlank
    @Column(name = "homecity")
    private String hCity;

    @Valid
    @NotBlank
    @Column(name = "homestate")
    private String hState;

    @Valid
    @NotBlank
    @Column(name = "homezip")
    private String hZip;


    @Valid
    @NotBlank
    @Column(name = "time_created")
    private Timestamp created;

    @Column(name = "status")
    private Boolean enabled;

    // @OneToOne(cascade = CascadeType.ALL)
    // private ConfirmationToken confirmationtoken;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "rolejoin", joinColumns = @JoinColumn(name= "user_id"), inverseJoinColumns = @JoinColumn(name = "roleid"))
    private Set<role> roles;



    public user() {
    }

    public user(int userId, String firstName, String lastName, String userName, String passWord, String email, String phonenumber, String hAddress, String hCity, String hState, String hZip, Timestamp created, Boolean enabled, Set<role> roles) {
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
        this.created = created;
        this.enabled = enabled;
        this.roles = roles;
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

    public Timestamp getCreated() {
        return this.created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<role> roles) {
        this.roles = roles;
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

    public user created(Timestamp created) {
        this.created = created;
        return this;
    }

    public user enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public user roles(Set<role> roles) {
        this.roles = roles;
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
        return userId == user.userId && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(userName, user.userName) && Objects.equals(passWord, user.passWord) && Objects.equals(email, user.email) && Objects.equals(phonenumber, user.phonenumber) && Objects.equals(hAddress, user.hAddress) && Objects.equals(hCity, user.hCity) && Objects.equals(hState, user.hState) && Objects.equals(hZip, user.hZip) && Objects.equals(created, user.created) && Objects.equals(enabled, user.enabled) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, userName, passWord, email, phonenumber, hAddress, hCity, hState, hZip, created, enabled, roles);
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
            ", created='" + getCreated() + "'" +
            ", enabled='" + isEnabled() + "'" +
            ", roles='" + getRoles() + "'" +
            "}";
    }

}
