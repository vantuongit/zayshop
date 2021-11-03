package edu.vinaenter.model;

import javax.validation.constraints.NotBlank;

public class User {

	private int u_id;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String fullname;
	
	private String password;
	
	private Role role;
	
	

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User(int u_id, String username, String fullname, String password, Role role) {
		super();
		this.u_id = u_id;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
	}

	
}
