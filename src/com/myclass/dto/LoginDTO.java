package com.myclass.dto;

public class LoginDTO {
	private int id;
	private String email;
	private String password;
	private String fullname;
	private String roleName;
	
	public LoginDTO() {
	}

	public LoginDTO(String email, String password, String fullname, String roleName, int id) {
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.roleName = roleName;
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
