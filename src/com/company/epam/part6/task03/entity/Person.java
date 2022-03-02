package com.company.epam.part6.task03.entity;

import java.io.Serializable;

public abstract class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private static int genId = 1;
	private int id;
	private String name;
	private String lastname;
	private Sex sex;
	private String address;


	public Person() {
		this.id = genId++;
		this.name = "";
		this.lastname = "";
		this.sex = Sex.MALE;
		this.address = "";
	}

	public Person(String name, String lastname, Sex sex, String address) {
		this();
		this.name = name;
		this.lastname = lastname;
		this.sex = sex;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Person person = (Person) o;

		if (!name.equals(person.name)) {
			return false;
		}
		if (!lastname.equals(person.lastname)) {
			return false;
		}
		if (sex != person.sex) {
			return false;
		}
		return address.equals(person.address);
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + lastname.hashCode();
		result = 31 * result + sex.hashCode();
		result = 31 * result + address.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return String.format("Person: #%d,\t%s, %s, %s,\t%s", id, lastname, name, sex.toString(), address);
	}
}
