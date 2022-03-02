package com.company.epam.part6.task02.logic;

import com.company.epam.part6.task02.entity.Note;

import java.util.List;

public class NotepadPrinter {

	/**
	 * Prints the provided list of the notes in the console.
	 *
	 * @param notes the list of the notes
	 */
	public static void printNotes(List<Note> notes) {
		for (Note note : notes) {
			System.out.println(note);
		}
	}

	/**
	 * Prints error message by provided {@link PrinterCode} value.
	 *
	 * @param code the value of printer code.
	 */
	public static void printCodeLineError(PrinterCode code) {
		System.out.print("Provided " + code.toString() + " is incorrect! ");
		switch (code) {
			case EMAIL:
				System.out.println("Please, use the next format xxxxx@xxx.xx. Try again!");
				break;
			case DATE:
				System.out.println("Please, use the next format dd/MM/yy. Try again!");
				break;
			case TEXT:
				System.out.println("Please, enter at least 4 letters. Try again!");
				break;
			case WORD:
				System.out.println("Please, enter at least 1 letter. Try again!");
				break;
			default:
				throw new IllegalArgumentException("There is no such code: " + code);
		}

	}

	/**
	 * Prints asking message by provided {@link PrinterCode} value.
	 *
	 * @param code the value of printer code.
	 */
	public static void printCodeLineHelper(PrinterCode code) {
		System.out.println("Please, enter " + code.name().toLowerCase() + " value:");
	}
}
