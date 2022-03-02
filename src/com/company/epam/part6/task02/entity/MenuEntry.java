package com.company.epam.part6.task02.entity;

public abstract class MenuEntry {

	private String title;

	public MenuEntry(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public abstract void run();
}
