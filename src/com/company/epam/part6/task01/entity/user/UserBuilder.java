package com.company.epam.part6.task01.entity.user;

public class UserBuilder {

	private User user;

	public UserBuilder(String username, String password) {
		user = new User(username, password);
	}

	public UserBuilder withName(String name){
		user.setName(name);
		return this;
	}

	public UserBuilder withLastname(String lastname){
		user.setLastname(lastname);
		return this;
	}

	public UserBuilder setSex(Sex sex){
		user.setSex(sex);
		return this;
	}

	public UserBuilder setRole(Role role){
		user.setRole(role);
		return this;
	}

	public UserBuilder setEmail(Email email){
		user.setEmail(email);
		return this;
	}

	public UserBuilder setSalt(String salt){
		user.setSalt(salt);
		return this;
	}

	public User build(){
		return user;
	}
}
