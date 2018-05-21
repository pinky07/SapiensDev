package com.jackrutorial.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
@Entity
@Table(name="customersapiensdev")
public class Customer {

 @Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", comments=" + comments + "]";
	}

@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 
 @Column(name = "firstname")
 private String firstname;
 
 @Column(name = "lastname")
 private String lastname;
 
 @Email(message="Please provide a valid email address")
 @Column(name = "email")
 private String email;
 
 @NotEmpty
 @Column(name = "comments")
 private String comments;
 
 @NotEmpty
 @Column(name = "recommendations")
 private String recommendations;
 
 @Temporal(TemporalType.TIMESTAMP)
 @CreationTimestamp
 @Column(name = "createdate")
 private Date  createdate;



public Date getCreatedate() {
	return createdate;
}

public void setCreatedate(Date createdate) {
	this.createdate = createdate;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getComments() {
	return comments;
}

public void setComments(String comments) {
	this.comments = comments;
}

public String getRecommendations() {
	return recommendations;
}

public void setRecommendations(String recommendations) {
	this.recommendations = recommendations;
}


}