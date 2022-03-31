package com.example.RestLOgin.ApiRestLoginTest.entity;
import javax.persistence.*;

@Entity
@Table(name="users")

public class User {

	@GeneratedValue
	@Id
	@Column(name="ID",unique = true)
	private long id;
	
	@Column(name="email",unique = true)
	private String email;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;
	
	@Column(name="username")
	private String username;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
