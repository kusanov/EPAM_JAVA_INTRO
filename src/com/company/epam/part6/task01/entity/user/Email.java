package com.company.epam.part6.task01.entity.user;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

	private String name;
	private List<Letter> inbox;
	private List<Letter> outbox;

	public Email(String name) {
		this.name = name;
		this.inbox = new ArrayList<>();
		this.outbox = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		Pattern pattern = Pattern.compile("^[a-z_]{2,20}@[a-z]{2,4}\\.[a-z]{2,3}$");
		Matcher matcher = pattern.matcher(name);

		if (matcher.matches()) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Illegal email name: " + name);
		}
	}

	public List<Letter> getInbox() {
		return inbox;
	}

	public List<Letter> getOutbox() {
		return outbox;
	}

	public void printInbox() {
		inbox.forEach(System.out::println);
	}

	public void printOutbox() {
		outbox.forEach(System.out::println);
	}

	@Override
	public String toString() {
		return name;
	}
}
