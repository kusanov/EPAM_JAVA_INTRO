package com.company.epam.part6.task01.entity.book;

import java.util.List;

public class Pagination<T> {

	private List<T> elements;
	private int currentPos;
	private static final int PAGE = 2;

	public Pagination(List<T> elements) {
		this.elements = elements;
		this.currentPos = 0;
	}

	/**
	 * Prints the next page.
	 */
	public void nextPage(){
		while (currentPos < elements.size()) {
			System.out.println(elements.get(currentPos++));
			if (currentPos % PAGE == 0) {
				break;
			}
		}
		if (currentPos == elements.size()) {
			currentPos = 0;
		}
	}

	/**
	 * Prints the previous page.
	 */
	public void previousPage() {
		this.currentPos -= PAGE;
		if (this.currentPos < 0) {
			this.currentPos = 0;
		}
		nextPage();
	}
}
