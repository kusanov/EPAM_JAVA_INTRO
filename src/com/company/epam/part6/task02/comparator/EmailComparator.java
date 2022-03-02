package com.company.epam.part6.task02.comparator;

import com.company.epam.part6.task02.entity.Note;

import java.util.Comparator;

public class EmailComparator implements Comparator<Note> {

	@Override
	public int compare(Note o1, Note o2) {
		return o1.getEmail().compareToIgnoreCase(o2.getEmail());
	}
}
