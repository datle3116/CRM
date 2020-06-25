package com.myclass.dto;

public class UserDTO {
	private int id;
	private String email;
	private String password;
	private String fullname;
	private String description;
	private String roleName;
	public UserDTO() {
	}
	public UserDTO(int id, String email, String fullname, String description, String password, String roleName) {
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.description = description;
		this.password = password;
		this.roleName = roleName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
