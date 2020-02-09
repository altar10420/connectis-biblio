package com.connectis.programator.demo.biblioteka;
/*
Napisz program do obsługi biblioteki. Ma posiadać następujące funkcjonalności:

- Program działa dopóki użytkownik nie wpisze "Exit", każda funkcjonalność oferuje podmenu i
    możliwość przemieszczania się między funkcjonalnościami
- Katalog książek (wystarczy kilka) do wypożyczenia (wszystkie możliwe książki powinny być zapisane w pliku)
    - Książka musi mieć minimum: tytuł, rok wydania, autora oraz swoje ID (proponuję użyć tutaj ISBN)
- Dane o wypożyczonych książkach trzymamy w pamięci (wybierz odpowiednią strukturę danych), stwórz klasę,
 która będzie reprezentować repozytorium książek
    - Ta klasa jako jedyna ma możliwość wykonywania operacji typu weź książkę, wypożycz książkę itp.
- Przez interakcję przez konsolę, użytkownik może wypożyczyć egzemplarz danej książki, jeśli jest on dostępny.
 Jeśli nie, powinien się o tym dowiedzieć
- Użytkownik może wyświetlić listę wszystkich dostępnych książek
- Użytkownik może wyszukać książki po wszystkich atrybutach (fraza tytułu, rok wydania, autor, ID)
- Użytkownik może dodać nową książkę do zbioru (donacja)
    - Biblioteka nie przyjmuje duplikatów, jeśli książka o zadanym ISBN już istnieje w zbiorze, nie przyjmuje donacji
- Spróbuj zrobić kod obiektowo, tj. przy użyciu jak najmniejszej ilości statycznych metod i pól.
    Wyjątkiem jest metoda main lub jeśli używasz słówka static świadomie (np. deklarując jakąś stałą w klasie).
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainBiblio {

    public static void main(String[] args) throws IOException {

        //        BooksRepository booksRepository = new BooksRepository();

        BooksRepository booksRepository = readCSVdatabase("<path-to-database-file>/database.csv");

        BooksReservationSystem booksReservationSystem = new BooksReservationSystem(booksRepository);

//        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 1937, "ISBN-0123");
//        Book book2 = new Book("Hamlet", "William Shakespeare", 1601, "ISBN-456");
//        Book book3 = new Book("Christine", "Stephen King", 1983, "ISBN-089");
//        Book book4 = new Book("The Hobbit", "J.R.R. Tolkien", 1937, "ISBN-7654");
//        Book book5 = new Book("Alice in wonderland", "Lewis Carroll", 1896, "ISBN-4632");
//
//        booksRepository.addBookToRepository(book);
//        booksRepository.addBookToRepository(book2);
//        booksRepository.addBookToRepository(book3);
//        booksRepository.addBookToRepository(book4);

        UserInterface userInterface = new UserInterface(booksRepository);

        userInterface.run();

    }

    private static BooksRepository readCSVdatabase(String filename) {
        BooksRepository booksRepository = new BooksRepository();

        Path pathToFile = Paths.get(filename);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {

            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");

                booksRepository.addBookToRepository(new Book(attributes[0],
                        attributes[1],
                        Integer.parseInt(attributes[2]),
                        attributes[3]));
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return booksRepository;
    }
}


