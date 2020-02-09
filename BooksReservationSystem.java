package com.connectis.programator.demo.biblioteka;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class BooksReservationSystem {

    private Map<String, Status> booksReservationMap;

    private BooksRepository booksRepository;

    public BooksReservationSystem(BooksRepository booksRepository) {

        this.booksRepository = booksRepository;

        booksReservationMap = new TreeMap<>();

    }

    public void borrowBook(String ISBN) {
        if (booksRepository.bookExistsInRepo(ISBN)
                && !this.isBookBorrowed(ISBN)
                && !this.isBookReserved(ISBN)) {
            booksReservationMap.put(ISBN, Status.BORROWED);
        }
    }


    public void returnBook(String ISBN) {
        if (this.isBookBorrowed(ISBN)) {

            booksReservationMap.remove(ISBN);
        }
    }

    public void reserveBook(String ISBN) {
        if (this.isBookBorrowed(ISBN) && !this.isBookReserved(ISBN)) {

            booksReservationMap.put(ISBN, Status.RESERVED);

        }
    }


    private boolean isBookBorrowed(String ISBN) {

        return booksReservationMap.get(ISBN) == Status.BORROWED;
    }

    private boolean isBookReserved(String ISBN) {

        return booksReservationMap.get(ISBN) == Status.RESERVED;
    }


    public Optional<Status> bookStatus(String ISBN) {

        if (booksRepository.bookExistsInRepo(ISBN)) {
            return Optional.of(booksReservationMap.getOrDefault(ISBN, Status.AVAILABLE));
        }
        return Optional.empty();
    }


    @Override
    public String toString() {
        return "BooksReservationSystem{" +
                "booksReservationMap=" + booksReservationMap +
                '}';
    }
}
