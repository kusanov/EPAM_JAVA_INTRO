package com.company.epam.part6.task04.entity;

public class Cargo {

	private static int genID = 1;
	private int id;

	public Cargo() {
		id = genID++;
	}

	@Override
	public String toString() {
		return "Cargo #" + id;
	}
}
