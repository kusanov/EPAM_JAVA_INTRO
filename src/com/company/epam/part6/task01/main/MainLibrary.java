package com.company.epam.part6.task01.main;

import com.company.epam.part6.task01.entity.book.Book;
import com.company.epam.part6.task01.entity.book.BookBuilder;
import com.company.epam.part6.task01.entity.book.Type;
import com.company.epam.part6.task01.entity.user.User;
import com.company.epam.part6.task01.entity.catalog.Catalog;
import com.company.epam.part6.task01.entity.book.Pagination;
import com.company.epam.part6.task01.dao.UserUtils;

//Задание 1: создать консольное приложение “Учет книг в домашней библиотеке”.
//		Общие требования к заданию:
//		• Система учитывает книги как в электронном, так и в бумажном варианте.
//		• Существующие роли: пользователь, администратор.
//		• Пользователь может просматривать книги в каталоге книг, осуществлять поиск
//		книг в каталоге.
//		• Администратор может модифицировать каталог.
//		• *При добавлении описания книги в каталог оповещение о ней рассылается на
//		e-mail всем пользователям
//		• **При просмотре каталога желательно реализовать постраничный просмотр
//		• ***Пользователь может предложить добавить книгу в библиотеку, переслав её
//		администратору на e-mail.
//		• Каталог книг хранится в текстовом файле.
//		• Данные аутентификации пользователей хранятся в текстовом файле. Пароль
//		не хранится в открытом виде


public class MainLibrary {

	public static void main(String[] args) {

		Catalog catalog = Catalog.getCatalog("admin", "admin");

		Pagination<Book> catalogBooks = new Pagination<>(catalog.getBooks());
		System.out.println("Вывод первой страницы:");
		catalogBooks.nextPage();
		System.out.println("Вывод следующей страницы:");
		catalogBooks.nextPage();
		System.out.println("Вывод предыдущей страницы:");
		catalogBooks.previousPage();

		Book book = new BookBuilder().withTitle("Java from EPAM")
		                             .withAuthors(new String[]{"Блинов"})
		                             .setPublisher("Четыре четверти")
		                             .setYear(2020)
		                             .setPageNum(560)
		                             .setType(Type.E_BOOK)
		                             .build();
		System.out.println("Добавляем новую книгу:" + book);
		catalog.addBook(book);
		catalog.removeBook(book);

		User user = new User("seeker", "seeker");

		catalog.setUser(user);

		System.out.println("Поиск по автору:");
		Pagination<Book> searchBook1 = new Pagination<>(catalog.findBooksByAuthor("Хорстманн"));
		searchBook1.nextPage();

		System.out.println("Поиск по названию:");
		Pagination<Book> searchBook2 = new Pagination<>(catalog.findBooksByTitle("Паттерны проектирования"));
		searchBook2.nextPage();

		System.out.println("Отправка уведомлений:");

		Book book2 = new BookBuilder().withTitle("C++")
		                            .withAuthors(new String[]{"NotBloch"})
		                            .setPublisher("North Star")
		                            .setYear(2001)
		                            .setPageNum(820)
		                            .setType(Type.PAPER)
		                            .build();

		catalog.sendBookToCatalog("Add this book, please!", "It's a very helpful book", book2);

		catalog.getUser().getEmail().printInbox();
		catalog.getUser().getEmail().printOutbox();

		UserUtils.addUser("reader", "reader");

		UserUtils.removeUser("reader", "reader");

	}
}
