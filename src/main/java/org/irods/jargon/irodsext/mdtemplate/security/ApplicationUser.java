package org.irods.jargon.irodsext.mdtemplate.security;

public class ApplicationUser {

	private String username;
	private String password;
	private String role;



	public ApplicationUser(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public ApplicationUser() {}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean match(String name, String password) {
		return this.username.equals(name) && this.password.equals(password);
	}

}
