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

