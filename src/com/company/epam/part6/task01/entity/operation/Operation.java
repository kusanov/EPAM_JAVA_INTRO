package com.company.epam.part6.task01.entity.operation;

public enum Operation {
	ADDED,
	REMOVED;

	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
