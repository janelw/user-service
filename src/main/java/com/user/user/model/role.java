package com.user.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table
public class role {

@Id
@Column
@GeneratedValue(strategy = GenerationType.IDENTITY)
@SequenceGenerator(name = "role_sequence", schema = "role_sequence")
private int id;
private Boolean isRecr;
private Boolean isPanel;
private Boolean isCand;
private Boolean isDelHd;
private Boolean isHrAd;
}
