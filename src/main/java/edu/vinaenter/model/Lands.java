package edu.vinaenter.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

public class Lands {
	
	private int lid;
	
	@NotBlank
	private String lname;
	
	@NotBlank
	private String description;
	
	private Timestamp date_create;
	
	private String picture;
	
	private int area;
	@NotBlank
	private String address;
	
	private int count_views;
	
	private Category category;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCount_views() {
		return count_views;
	}

	public void setCount_views(int count_views) {
		this.count_views = count_views;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}




	public Lands(int lid, String lname, String description, Timestamp date_create, String picture, int area,
			String address, int count_views, Category category) {
		super();
		this.lid = lid;
		this.lname = lname;
		this.description = description;
		this.date_create = date_create;
		this.picture = picture;
		this.area = area;
		this.address = address;
		this.count_views = count_views;
		this.category = category;
	}

	public Lands() {
		super();
	}

	public Lands(String search) {
	}

	@Override
	public String toString() {
		return "Lands [lid=" + lid + ", lname=" + lname + ", description=" + description + ", date_create="
				+ date_create + ", picture=" + picture + ", area=" + area + ", address=" + address + ", count_views="
				+ count_views + ", category=" + category + "]";
	}
	
	
}
