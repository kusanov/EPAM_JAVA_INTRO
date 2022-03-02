package com.company.epam.part6.task03.entity;

public class Student extends Person {

	private String faculty;

	public Student(String faculty) {
		super();
		this.faculty = faculty;
	}

	public Student(String name, String lastname, Sex sex, String address, String faculty) {
		super(name, lastname, sex, address);
		this.faculty = faculty;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	@Override
	public boolean equals(Object o) {
		if (!super.equals(o)) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}

		Student student = (Student) o;

		return faculty.equals(student.faculty);
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + faculty.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return super.toString() + ", faculty: " + faculty;
	}
}
