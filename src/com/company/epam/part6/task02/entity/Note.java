package com.company.epam.part6.task02.entity;

import java.time.LocalDate;

public class Note {

	private String subject;
	private LocalDate dateOfCreation;
	private String email;
	private String message;

	public Note() {
		this.subject = "";
		this.dateOfCreation = LocalDate.MIN;
		this.email = "";
		this.message = "";
	}

	public Note(String subject, LocalDate dateOfCreation, String email, String message) {
		this.subject = subject;
		this.dateOfCreation = dateOfCreation;
		this.email = email;
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public LocalDate getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(LocalDate dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("Subject: %s, date of creation: %s, email: %s, message: %s",
				subject, dateOfCreation, email, message);
	}
}
