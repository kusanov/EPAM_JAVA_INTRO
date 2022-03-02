package com.company.epam.part6.task02.logic;

import com.company.epam.part6.task02.entity.Note;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * The class is a singleton.
 */
public class NotepadFileHandler {

	private static NotepadFileHandler instance;

	private String csvFile = "src\\com\\company\\epam\\part6\\task02\\data/notes.csv";
	private String datePattern = "dd/MM/yy";

	private NotepadFileHandler() {
	}

	public static NotepadFileHandler getInstance() {
		if (instance == null) {
			return new NotepadFileHandler();
		} else return instance;
	}

	/**
	 * Load the list of the notes from the csv file.
	 *
	 * @return the list of the notes.
	 */
	public List<Note> loadNotes() {
		List<Note> notes = new ArrayList<>();

		String line;
		String splitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				String[] data = line.split(splitBy);

				Note note = new Note();
				if (!data[0].isEmpty()) {
					note.setSubject(data[0]);
				}

				if (!data[1].isEmpty()) {
					note.setDateOfCreation(LocalDate.parse(data[1], DateTimeFormatter.ofPattern(datePattern)));
				}

				if (!data[2].isEmpty()) {
					note.setEmail(data[2]);
				}

				if (!data[3].isEmpty()) {
					note.setMessage(data[3]);
				}

				notes.add(note);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return notes;
	}

	/**
	 * Save the list of the notes to the csv file.
	 */
	public void saveNotepad(List<Note> notes) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
			for (Note note : notes) {
				StringBuilder sb = new StringBuilder();

				sb.append(note.getSubject());
				sb.append(",");
				sb.append(note.getDateOfCreation().format(DateTimeFormatter.ofPattern(datePattern)));
				sb.append(",");
				sb.append(note.getEmail());
				sb.append(",");
				sb.append(note.getMessage());

				bw.write(sb.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
