package com.company.epam.part6.task03.entity;

public enum Sex {
	MALE,
	FEMALE;

	@Override
	public String toString() {
		return this.name().toLowerCase();
	}
}
