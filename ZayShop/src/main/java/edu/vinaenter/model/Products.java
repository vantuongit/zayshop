package edu.vinaenter.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

public class Products {
	
	private int pid;
	
	@NotBlank
	private String pname;
	
	@NotBlank
	private String detail;
	
	private float price;
	
	private Timestamp date_create;
	
	private String picture;
	
	private int count_views;
	
	private Category category;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Products(int pid, String pname, String detail, Timestamp date_create, String picture, int area,
			String address, int count_views, Category category) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.detail = detail;
		this.date_create = date_create;
		this.picture = picture;
		this.count_views = count_views;
		this.category = category;
	}

	public Products() {
		super();
	}

	public Products(String search) {
	}

	@Override
	public String toString() {
		return "Products [pid=" + pid + ", pname=" + pname + ", detail=" + detail + ", price=" + price
				+ ", date_create=" + date_create + ", picture=" + picture + ", count_views=" + count_views
				+ ", category=" + category + "]";
	}

	public Products(int pid, @NotBlank String pname, @NotBlank String detail, float price, Timestamp date_create,
			String picture, int count_views, Category category) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.detail = detail;
		this.price = price;
		this.date_create = date_create;
		this.picture = picture;
		this.count_views = count_views;
		this.category = category;
	}
	
	
}
