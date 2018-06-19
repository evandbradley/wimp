package com.el.ally.wimp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="actor")
public class Actor {

	@Id
    @GeneratedValue // Skip AUTO generation type
    private int id;
	
	@Column(length=75, nullable=false)
	String firstName;
	
	@Column(length=75, nullable=true)
	String lastName;
	
	@Column(nullable=true)
	Long activeSinceYear;
	
	@Column(nullable=true)
	Date longDate;

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

	public Long getActiveSinceYear() {
		return activeSinceYear;
	}

	public void setActiveSinceYear(Long activeSinceYear) {
		this.activeSinceYear = activeSinceYear;
	}

	public Date getLongDate() {
		return longDate;
	}

	public void setLongDate(Date longDate) {
		this.longDate = longDate;
	}
}
