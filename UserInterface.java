package com.connectis.programator.demo.biblioteka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {

    private boolean running;
    private BooksRepository booksRepository;
    private BooksReservationSystem booksReservationSystem;

    public UserInterface(BooksRepository booksRepository) {
        this.running = true;
        this.booksRepository = booksRepository;
        this.booksReservationSystem = new BooksReservationSystem(booksRepository);

    }

    public void run() throws IOException {


        while (running) {


            System.out.println("\nWelcome to the library.\nPlease choose your option:");
            System.out.println("1 - Show library resources");
            System.out.println("2 - Search for a book");
            System.out.println("3 - Borrow a book");
            System.out.println("4 - Return a book");
            System.out.println("5 - Donate a book to the library");
            System.out.println("Exit - exit system");

            String userInput = readUserInput();

            switch (userInput) {
                case "1":
                    System.out.println(booksRepository);
                    continue;
                case "2":
                    System.out.println("1 - search by ISBN");
                    System.out.println("2 - search by title");
                    System.out.println("0 - return...");
                    userInput = readUserInput();

                    switch (userInput) {
                        case "1":
                            System.out.println("Enter ISBN");
                            userInput = readUserInput();
                            System.out.println(booksRepository.findBookByISBN(userInput) +
                                    "" + booksReservationSystem.bookStatus(userInput));
                            continue;
                        case "2":
                            System.out.println("Enter title");
                            userInput = readUserInput();
                            System.out.println(booksRepository.findBookByTitle(userInput));
                            continue;
                        case "0":
                            continue;
                    }
                case "3":
                    System.out.println("Enter ISBN");
                    userInput = readUserInput();
                    if (booksReservationSystem.bookStatus(userInput).get() == Status.BORROWED) {
                        System.out.println("This book is already borrowed. Reservation is made instead.");
                        booksReservationSystem.reserveBook(userInput);
                        System.out.println(booksRepository.findBookByISBN(userInput) +
                                "" + booksReservationSystem.bookStatus(userInput));
                    } else if (booksReservationSystem.bookStatus(userInput).get() == Status.RESERVED) {
                        System.out.println("This book is already borrowed and reserved. Please try again next month.");
                    } else {
                        booksReservationSystem.borrowBook(userInput);
                        System.out.println(booksRepository.findBookByISBN(userInput) +
                                "" + booksReservationSystem.bookStatus(userInput));
                    }
                    continue;
                case "4":
                    System.out.println("Enter ISBN");
                    userInput = readUserInput();
                    if (booksReservationSystem.bookStatus(userInput).get() == Status.BORROWED) {
                        booksReservationSystem.returnBook(userInput);
                    } else {
                        System.out.println("This book is not borrowed from our library.");
                    }
                    continue;

                case "5":
                    System.out.println("Enter ISBN");
                    userInput = readUserInput();
                    if (booksRepository.bookExistsInRepo(userInput)) {
                        System.out.println("We already have this book. Thanks anyway.");
                        continue;
                    } else {
                        System.out.println("Enter title:");
                        String title = readUserInput();
                        System.out.println("Enter authors:");
                        String author = readUserInput();
                        System.out.println("Enter year of first publishing");
                        String year = readUserInput();
                        int yearInteger;
                        try {
                            yearInteger = Integer.parseInt(year);
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR! Please try again with valid year.");
                            continue;
                        }
                        yearInteger = Integer.parseInt(year);
                        booksRepository.addBookToRepository(new Book(title, author, yearInteger, userInput));
                        System.out.println("Book has been added. Thank you.");
                        continue;
                    }

                case "Exit":
                    running = false;
            }

        }
    }

    private static String readUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
