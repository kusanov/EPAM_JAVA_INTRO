package com.company.epam.part4;

public class Book4 {
    private int id;
    private String title;
    private String author;
    private String publishingHouse;
    private int publicationYear;
    private int numberPages;
    private double price;
    private String typeBinding;

    public Book4() {
    }

    public Book4(int id, String title, String author, String publishingHouse, int publicationYear, int numberPages, double price, String typeBinding) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.publicationYear = publicationYear;
        this.numberPages = numberPages;
        this.price = price;
        this.typeBinding = typeBinding;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTypeBinding() {
        return typeBinding;
    }

    public void setTypeBinding(String typeBinding) {
        this.typeBinding = typeBinding;
    }

    @Override
    public String toString() {
        return "Книга: " +
                "id - " + id +
                ", название - '" + title + '\'' +
                ", автор(ы) - '" + author + '\'' +
                ", издательство - '" + publishingHouse + '\'' +
                ", год издания - " + publicationYear +
                ", количество страниц - " + numberPages +
                ", цена - " + price +
                ", тип переплета - '" + typeBinding + '\'' +
                '.';
    }
}
