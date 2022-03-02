package com.company.epam.part4;

public class Books {

    private Book4[] book;

    public Books() {
    }

    public Books (Book4[] book) {
        this.book = book;
    }


    //список книг заданного автора;
    public void searchAuthor(String author) {
        boolean test = true;
        for (Book4 b : this.book) {
            if (b.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                test = false;
                System.out.println(b.toString());
            }
        }
        if (test) {
            System.out.println("Книги автора '" + author + "' не найдены.");
        }
    }

    //список книг, выпущенных заданным издательством
    public void searchPublishingHouse(String publishingHouse) {
        boolean test = true;
        for (Book4 b : this.book) {
            if (publishingHouse.equals(b.getPublishingHouse())) {
                test = false;
                System.out.println(b.toString());
            }
        }
        if (test) {
            System.out.println("Книги издательства '" + publishingHouse + "' не найдены.");
        }
    }

    //список книг, выпущенных после заданного года.
    public void searchPublicationYear(int publicationYear) {
        boolean test = true;
        for (Book4 b : this.book) {
            if (publicationYear <= b.getPublicationYear()) {
                test = false;
                System.out.println(b.toString());
            }
        }
        if (test) {
            System.out.println("Книги, выпущенные после " + publicationYear + " года, не найдены.");
        }
    }

    public Book4[] getBook() {
        return book;
    }

    public void setBook(Book4[] book) {
        this.book = book;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Book4 value : book) {
            str.append(value.toString() + "\n");
        }
        return str.toString();
    }
}
