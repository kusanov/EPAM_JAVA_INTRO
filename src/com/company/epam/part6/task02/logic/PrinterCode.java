package com.company.epam.part6.task02.logic;

public enum PrinterCode {
	TEXT,
	EMAIL,
	DATE,
	WORD;

	@Override
	public String toString() {
		return this.name().toLowerCase();
	}
}
