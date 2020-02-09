package com.connectis.programator.demo.biblioteka;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class BooksRepository {

    private Map<String, Book> booksRepository;

    public BooksRepository() {

        booksRepository = new TreeMap<>();
    }


    public boolean bookExistsInRepo(String ISBN) {

        return booksRepository.containsKey(ISBN);
    }


    public void addBookToRepository(Book book) {

        if (!this.bookExistsInRepo(book.getISBN())) {

            booksRepository.put(book.getISBN(), book);
        }
    }


    public Optional<Book> findBookByISBN(String ISBN) {

        return Optional.ofNullable(booksRepository.get(ISBN));
    }


    public Optional<Book> findBookByTitle(String title) {

        for (Book book : booksRepository.values()) {
            if (title.equals(book.getTitle())) {
                return Optional.of(booksRepository.get(book.getISBN()));
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {

        String result = "";

        for (String s : booksRepository.keySet()) {
            result += s + " =" + booksRepository.get(s);
        }

        return result;
    }
}
