package com.kris.ss;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
	//"name","stars","pos","location","height","weight","fortyDash","rating","gradYear"
	
	public Player(long id, String name, String location, String pos, int stars,
			String height, Double fortyDash, int weight, int gradYear,
			Double rating) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.pos = pos;
		this.stars = stars;
		this.height = height;
		this.fortyDash = fortyDash;
		this.weight = weight;
		this.gradYear = gradYear;
		this.rating = rating;
	}
	
	
	public Player() {
		// TODO Auto-generated constructor stub
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String name;
	private String location;
	private String pos;
	private int stars;
	private String height;
	private Double fortyDash;
	private int weight;
	private int gradYear;
	private Double rating;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public Double getFortyDash() {
		return fortyDash;
	}
	public void setFortyDash(Double fortyDash) {
		this.fortyDash = fortyDash;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getGradYear() {
		return gradYear;
	}
	public void setGradYear(int gradYear) {
		this.gradYear = gradYear;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", location=" + location
				+ ", gradYear=" + gradYear + "]";
	}
	
	

}
