package com.company.epam.part6.task02.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	private static final String MENU_PATTERN = "%s - %s\n";

	private List<MenuEntry> entries;

	private boolean isExit = false;

	public Menu() {
		entries = new ArrayList<>();
	}

	public void setExit(boolean exit) {
		isExit = exit;
	}

	public void run() {
		while (!isExit) {
			printMenu();
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			if (choice > entries.size()){
				continue;
			}
			MenuEntry entry = entries.get(choice - 1);
			entry.run();
		}
	}

	public Menu addEntry(MenuEntry entry) {
		entries.add(entry);
		return this;
	}

	private void printMenu() {
		StringBuilder builder = new StringBuilder();

		builder.append("\nMenu:\n");

		for (int i = 0; i < entries.size(); i++) {
			MenuEntry entry = entries.get(i);
			String entryFormatted = String.format(MENU_PATTERN, (i + 1), entry.getTitle());
			builder.append(entryFormatted);
		}

		System.out.print(builder.toString());
	}
}
