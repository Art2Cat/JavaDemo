package com.art2cat.dev.restful.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestObject {
	private String username;
	private String password;
	private String firstName;
	private String lastName;

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


	public List<Optional<String>> get() {
		return Arrays.asList(Optional.ofNullable(username),
				Optional.ofNullable(password),
				Optional.ofNullable(firstName),
				Optional.ofNullable(lastName)
		);
	}
}
