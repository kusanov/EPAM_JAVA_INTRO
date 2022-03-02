package com.company.epam.part6.task02.logic;

import com.company.epam.part6.task02.comparator.DateComparator;
import com.company.epam.part6.task02.comparator.EmailComparator;
import com.company.epam.part6.task02.entity.Note;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The class is a singleton.
 */
public class NotepadHandler {

	private static NotepadHandler instance;

	private static final String TEXT_REGEX = "^[a-zA-Z ,!?\"]{4,}$";
	private static final String EMAIL_REGEX = "^[a-z_.]{2,20}@[a-z]{2,5}\\.[a-z]{2,3}$";
	private static final String DATE_OF_CREATION_REGEX = "^\\d{2}/\\d{2}/\\d{2}$";
	private static final String WORD_REGEX = "^[a-zA-Z]+$";

	private List<Note> notes;
	private Scanner scanner;

	private NotepadHandler() {
		this.notes = NotepadFileHandler.getInstance().loadNotes();
		this.scanner = new Scanner(System.in);
		//separate input by new line
		scanner.useDelimiter("[\r\n]");
	}

	public static NotepadHandler getInstance() {
		if (instance == null) {
			return new NotepadHandler();
		} else return instance;
	}

	public List<Note> getNotes() {
		return notes;
	}

	/**
	 * Appends note to the list of {@link NotepadHandler#notes}.
	 */
	public void addNote() {

		String subject = getText();
		LocalDate date = LocalDate.now();
		String email = getEmail();
		String message = getText();

		Note note = new Note(subject, date, email, message);

		notes.add(note);
	}

	/**
	 * Sort {@link NotepadHandler#notes} by email value.
	 */
	public void sortNotesByEmail() {
		notes.sort(new EmailComparator());
	}

	/**
	 * Sort {@link NotepadHandler#notes} by date of creation.
	 */
	public void sortNotesByDate() {
		notes.sort(new DateComparator());
	}

	/**
	 * Finds all notes in the list of {@link NotepadHandler#notes} that have entered email value and adds it to the
	 * separated list of notes.
	 *
	 * @return the list of the notes
	 */
	public List<Note> getNotesByEmail() {
		List<Note> notesByEmail = new ArrayList<>();

		String email = getEmail();

		for (Note note : notes) {
			if (!note.getEmail().isEmpty() && note.getEmail().equals(email)) {
				notesByEmail.add(note);
			}
		}
		return notesByEmail;
	}

	/**
	 * Finds all notes in the list of {@link NotepadHandler#notes} that are after entered date and adds it to
	 * the separated list of notes.
	 *
	 * @return the list of the notes
	 */
	public List<Note> getNotesAfterDate() {
		List<Note> notesAfterDate = new ArrayList<>();

		LocalDate date = getDate();

		notes.stream().filter(note -> note.getDateOfCreation().isAfter(date)).forEach(notesAfterDate::add);
		return notesAfterDate;
	}

	/**
	 * Finds if the note message contains the provided word.
	 *
	 * @return the list of the notes
	 */
	public List<Note> findNotesByMessageWord() {
		List<Note> notesByMessageWord = new ArrayList<>();

		String word = getWord();

		for (Note note : notes) {
			if (!note.getMessage().isEmpty() && note.getMessage().contains(word)) {
				notesByMessageWord.add(note);
			}
		}
		return notesByMessageWord;
	}

	/**
	 * Save {@link NotepadHandler#notes} to the csv file.
	 */
	public void saveNotepad() {
		NotepadFileHandler.getInstance().saveNotepad(notes);
	}

	/**
	 * Get email value from the console using {@link NotepadHandler#scanner} and checks if it satisfy provided
	 * {@value EMAIL_REGEX}.
	 *
	 * @return the email value.
	 */
	private String getEmail() {
		String email;

		while (true) {
			NotepadPrinter.printCodeLineHelper(PrinterCode.EMAIL);

			email = scanner.nextLine();
			if (email.matches(EMAIL_REGEX)) {
				return email;
			} else {
				NotepadPrinter.printCodeLineError(PrinterCode.EMAIL);
			}
		}
	}

	/**
	 * Get date value from the console using {@link NotepadHandler#scanner} and checks if it satisfy provided
	 * {@value DATE_OF_CREATION_REGEX}.
	 *
	 * @return the local date value.
	 */
	private LocalDate getDate() {
		String providedDate;

		while (true) {
			NotepadPrinter.printCodeLineHelper(PrinterCode.DATE);

			providedDate = scanner.nextLine();
			if (providedDate.matches(DATE_OF_CREATION_REGEX)) {
				return LocalDate.parse(providedDate, DateTimeFormatter.ofPattern("dd/MM/yy"));
			} else {
				NotepadPrinter.printCodeLineError(PrinterCode.DATE);
			}
		}
	}

	/**
	 * Get text value from the console using {@link NotepadHandler#scanner} and checks if it satisfy provided
	 * {@value TEXT_REGEX}.
	 *
	 * @return the text value.
	 */
	private String getText() {
		String text;

		while (true) {
			NotepadPrinter.printCodeLineHelper(PrinterCode.TEXT);

			text = scanner.nextLine();

			if (text.matches(TEXT_REGEX)) {
				return text;
			} else {
				NotepadPrinter.printCodeLineError(PrinterCode.TEXT);
			}
		}
	}

	/**
	 * Get word value from the console using {@link NotepadHandler#scanner} and checks if it satisfy provided
	 * {@value WORD_REGEX}.
	 *
	 * @return the word value.
	 */
	private String getWord(){
		String word;

		while (true) {
			NotepadPrinter.printCodeLineHelper(PrinterCode.WORD);

			word = scanner.nextLine();

			if (word.matches(WORD_REGEX)) {
				return word;
			} else {
				NotepadPrinter.printCodeLineError(PrinterCode.WORD);
			}
		}
	}
}