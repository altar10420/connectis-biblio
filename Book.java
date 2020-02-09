package com.connectis.programator.demo.biblioteka;

public class Book {

    private final String title;
    private final String author;
    private final int year;
    private final String ISBN;


    public Book(String title, String author, int year, String ISBN) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return " '" + title + "'," + " '" + author + "', " + "'" + year + "', " + "'" + ISBN + "'\n";
    }

}
