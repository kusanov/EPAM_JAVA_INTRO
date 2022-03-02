package com.company.epam.part6.task01.entity.catalog;

import com.company.epam.part6.task01.entity.book.Book;
import com.company.epam.part6.task01.entity.user.Email;
import com.company.epam.part6.task01.entity.operation.Operation;

public interface CatalogObserver {

	void update(Operation operation, Book book, Email email);
}
