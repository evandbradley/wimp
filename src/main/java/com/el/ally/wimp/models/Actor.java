package com.el.ally.wimp.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="actor")
public class Actor {

	@Id
	@GeneratedValue(generator="actor_id_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="actor_id_seq", sequenceName="actor_id_seq")
    private int id;
	
	@Column(length=75, nullable=false)
	String firstName;
	
	@Column(length=75, nullable=true)
	String lastName;
	
	@Column(nullable=true)
	Long activeSinceYear;
	
	@Column(nullable=true)
	Date longDate;
	
	@ManyToMany(mappedBy="actors")
	private List<Movie> movies;

	public Actor() {
		movies = new ArrayList<Movie>();
	}
	
	public Actor(String string, String string2, long l, java.sql.Date date) {
		firstName = string;
		lastName = string;
		activeSinceYear = l;
		longDate = date;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	public void addMovie(Movie movie) {
		this.movies.add(movie);
	}

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
