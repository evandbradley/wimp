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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="movie")
public class Movie {

	@Id
	@GeneratedValue(generator="movie_id_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="movie_id_seq", sequenceName="movie_id_seq")
    private int id;
	
	@Column(length=300, nullable=false)
	String title;
	
	@Column(nullable=true)
	Date releaseDate;
	
	@Column(nullable=true)
	Long budget;
	
	@Column(length=500, nullable=false)
	String distributor;
	
	@JsonIgnore
	@ManyToMany
	private List<Actor> actors;
	
	public Movie() {
		actors = new ArrayList<Actor>();
	}
	
	public Movie(String string, java.sql.Date date, long l, String string2) {
		title = string;
		releaseDate = date;
		budget = l;
		distributor = string2;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	public void addActor(Actor actor) {
		this.actors.add(actor);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
}
