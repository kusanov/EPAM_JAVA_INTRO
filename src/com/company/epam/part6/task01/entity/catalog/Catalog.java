package com.company.epam.part6.task01.entity.catalog;

import com.company.epam.part6.task01.entity.book.Book;
import com.company.epam.part6.task01.entity.user.Email;
import com.company.epam.part6.task01.entity.user.Letter;
import com.company.epam.part6.task01.entity.user.User;
import com.company.epam.part6.task01.dao.CatalogFileHandler;
import com.company.epam.part6.task01.entity.operation.Operation;
import com.company.epam.part6.task01.dao.UserUtils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Catalog class is a singleton.
 */
public class Catalog {

	private static Catalog INSTANCE;

	private List<Book> books;

	private User user;
	private Email systemEmail;

	private Catalog(String username, String password) {
		this.user = UserUtils.login(username, password);
		this.books = CatalogFileHandler.loadBooks();
		this.systemEmail = new Email("catalog@mail.by");
	}

	public static Catalog getCatalog(String username, String password) {
		if (INSTANCE == null) {
			INSTANCE = new Catalog(username, password);
		}
		return INSTANCE;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = UserUtils.login(user.getUsername(), new String(user.getPassword()));
	}

	/**
	 * Send email to all admin users.
	 *
	 * @param subject the subject of the email.
	 * @param text the text of the email.
	 * @param content the content of the email.
	 */
	public void sendBookToCatalog(String subject, String text, Book content) {
		for (User user : UserUtils.getUsers()) {
			if (UserUtils.isAdmin(user)) {
				Letter letter = new Letter(this.user.getEmail(), user.getEmail(), subject, text, content);
				this.user.getEmail().getOutbox().add(letter);
				user.getEmail().getInbox().add(letter);
			}
		}
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Email getSystemEmail() {
		return systemEmail;
	}

	public void setSystemEmail(Email systemEmail) {
		this.systemEmail = systemEmail;
	}

	/**
	 * Appends the specified book to the end of this list.
	 *
	 * @param book element to be appended to this list
	 */
	public void addBook(Book book) {
		if (UserUtils.isAdmin(user) && !books.contains(book)) {
			books.add(book);
			CatalogFileHandler.saveCatalog(books);
			notifyObservers(Operation.ADDED, book, systemEmail);
		} else if (books.contains(book)) {
			System.out.println("The catalog contains this book!");
		} else if (!UserUtils.isAdmin(user)) {
			System.out.println("You don't have access for that operation!");
		}
	}

	/**
	 * Removes the first occurrence of the book from this list,
	 * if it is present.
	 *
	 * @param book to be removed from this list, if present
	 */
	public void removeBook(Book book) {
		if (UserUtils.isAdmin(user)) {
			books.remove(book);
			CatalogFileHandler.saveCatalog(books);
			notifyObservers(Operation.REMOVED, book, systemEmail);
		} else if (!books.contains(book)) {
			System.out.println("The catalog doesn't contain this book!");
		} else if (!UserUtils.isAdmin(user)) {
			System.out.println("You don't have access for that operation!");
		}
	}

	/**
	 * Returns the list of books by author or the empty list if there are no such books.
	 *
	 * @param author the author of the book
	 * @return the list of books by author
	 */
	public List<Book> findBooksByAuthor(String author) {
		List<Book> booksByAuthors = new ArrayList<>();

		books.forEach(book -> Arrays.stream(book.getAuthors())
		                            .filter(str -> str.equalsIgnoreCase(author))
		                            .map(str -> book)
		                            .forEach(booksByAuthors::add));

		return booksByAuthors;
	}

	/**
	 * Returns the list of books by title or the empty list if there are no such books.
	 *
	 * @param title the title of the book
	 * @return the list of books by title
	 */
	public List<Book> findBooksByTitle(String title) {

		return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
	}

	private void notifyObservers(Operation operation, Book book, Email systemEmail) {
		for (User user : UserUtils.getUsers()) {
			if (!UserUtils.isAdmin(user)) {
				user.update(operation, book, systemEmail);
			}
		}
	}
}
