package Task51;

//Задача 1
//Создайте. Класс Book (книга), в конструктор которого передавайте автора,
// название книги и количество страниц.
//
//Реализуйте интерфейс для сравнения книг: они должны сортироваться по авторам, а если авторы совпадают
// - по названиям (и там, и там - по алфавиту, "в словарном порядке"), а если и авторы совпадают
// - по количеству страниц (по возрастанию).

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task51 {

  public static void main(String[] args) {
    List<Book> books = new ArrayList<>();

    Book book = new Book("Fitzek Sebastian", "Der Seelenbrecher", 120);
    Book book1 = new Book("Ana Pawlik", " In den Klauen", 110);
    Book book2 = new Book("Georg Hohenester", "Münchner Lieblingstouren", 89);
    Book book3 = new Book("Fitzek Sebastian", "Die Therapie", 78);
    Book book4 = new Book("Fitzek Sebastian", " Elternabend", 85);
    Book book5 = new Book("Clive Bucher", " Mental Power", 68);

    books.add(book);
    books.add(book1);
    books.add(book2);
    books.add(book3);
    books.add(book4);
    books.add(book5);

    Collections.sort(books);
    for (Book b : books) {
      System.out.println(b);
    }
  }
}
