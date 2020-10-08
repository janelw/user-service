package com.user.user.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// import org.hibernate.annotations.NaturalId;
// import org.springframework.stereotype.Component;


@Entity
@Table(name = "temprole")
public class role {

@Id
@Column(name = "roleid")
@GeneratedValue(strategy = GenerationType.IDENTITY)
@SequenceGenerator(name = "role_sequence", schema = "role_sequence")
private int roleid;

@Column(name = "role_type")
private String role_type;


    public role() {
    }

    public role(int roleid, String role_type) {
        this.roleid = roleid;
        this.role_type = role_type;
    }

    public int getRoleid() {
        return this.roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRole_type() {
        return this.role_type;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    public role roleid(int roleid) {
        this.roleid = roleid;
        return this;
    }

    public role role_type(String role_type) {
        this.role_type = role_type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof role)) {
            return false;
        }
        role role = (role) o;
        return roleid == role.roleid && Objects.equals(role_type, role.role_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleid, role_type);
    }

    @Override
    public String toString() {
        return "{" +
            " roleid='" + getRoleid() + "'" +
            ", role_type='" + getRole_type() + "'" +
            "}";
    }

}
