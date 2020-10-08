package com.user.user.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "confirmtoken")
public class ConfirmationToken {
    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_VERIFIED = "VERIFIED";
    @Id
    @Column(name = "confirmid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token")
    private String confirmationToken;

    @Column
    private String status;

    @Column(name = "expiry_date")
    private Timestamp expiryDate;

    @Column(name = "issued_date")
    private Timestamp issuedDate;

    @Column(name = "confirm_date")
    private Timestamp confirmedDate;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private user user;

    public ConfirmationToken() {
    }

    public ConfirmationToken(Long id, String confirmationToken, String status, Timestamp expiryDate, Timestamp issuedDate, Timestamp confirmedDate, user user) {
        this.id = id;
        this.confirmationToken = confirmationToken;
        this.status = status;
        this.expiryDate = expiryDate;
        this.issuedDate = issuedDate;
        this.confirmedDate = confirmedDate;
        this.user = user;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfirmationToken() {
        return this.confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Timestamp getIssuedDate() {
        return this.issuedDate;
    }

    public void setIssuedDate(Timestamp issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Timestamp getConfirmedDate() {
        return this.confirmedDate;
    }

    public void setConfirmedDate(Timestamp confirmedDate) {
        this.confirmedDate = confirmedDate;
    }

    public user getUser() {
        return this.user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public ConfirmationToken id(Long id) {
        this.id = id;
        return this;
    }

    public ConfirmationToken confirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
        return this;
    }

    public ConfirmationToken status(String status) {
        this.status = status;
        return this;
    }

    public ConfirmationToken expiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public ConfirmationToken issuedDate(Timestamp issuedDate) {
        this.issuedDate = issuedDate;
        return this;
    }

    public ConfirmationToken confirmedDate(Timestamp confirmedDate) {
        this.confirmedDate = confirmedDate;
        return this;
    }

    public ConfirmationToken user(user user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ConfirmationToken)) {
            return false;
        }
        ConfirmationToken confirmationToken = (ConfirmationToken) o;
        return Objects.equals(id, confirmationToken.id) && Objects.equals(confirmationToken, confirmationToken.confirmationToken) && Objects.equals(status, confirmationToken.status) && Objects.equals(expiryDate, confirmationToken.expiryDate) && Objects.equals(issuedDate, confirmationToken.issuedDate) && Objects.equals(confirmedDate, confirmationToken.confirmedDate) && Objects.equals(user, confirmationToken.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, confirmationToken, status, expiryDate, issuedDate, confirmedDate, user);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", confirmationToken='" + getConfirmationToken() + "'" +
            ", status='" + getStatus() + "'" +
            ", expiryDate='" + getExpiryDate() + "'" +
            ", issuedDate='" + getIssuedDate() + "'" +
            ", confirmedDate='" + getConfirmedDate() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }

}
