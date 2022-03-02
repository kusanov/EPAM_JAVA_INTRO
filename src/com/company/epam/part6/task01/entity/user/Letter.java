package com.company.epam.part6.task01.entity.user;

import com.company.epam.part6.task01.entity.book.Book;

public class Letter {

	private Email from;
	private Email to;
	private String subject;
	private String text;
	private Book attachment;

	public Letter(Email from, Email to, String subject, String text, Book attachment) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
		this.attachment = attachment;
	}

	public Email getFrom() {
		return from;
	}

	public void setFrom(Email from) {
		this.from = from;
	}

	public Email getTo() {
		return to;
	}

	public void setTo(Email to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Book getAttachment() {
		return attachment;
	}

	public void setAttachment(Book attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return String.format("The letter from %s, to %s, subject: %s\n \"%s\"", from, to, subject, text);
	}
}
