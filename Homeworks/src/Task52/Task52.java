package Task52;

//Задача 1
//Используйте класс Book (книга) из предыдущего домашнего задания.
//
//Создайте компаратор, который позволит сортировать книги по названию,
// при одинаковых названиях - по автору (и там, и там - по алфавиту).
//Задача 2* (не обязательно)
//Создайте компаратор, который позволит сортировать книги по убыванию количества страниц,
// а при совпадающем объёме - по названиям ("по возрастанию", по алфавиту).

import java.util.ArrayList;
import java.util.List;

public class Task52 {

  public static void main(String[] args) {
    List<Book> books = new ArrayList<>();

    Book book = new Book("Fitzek Sebastian", "Der Seelenbrecher", 120);
    Book book1 = new Book("Ana Pawlik", "In den Klauen", 110);
    Book book2 = new Book("Georg Hohenester", "Münchner Lieblingstouren", 89);
    Book book3 = new Book("Fitzek Sebastian", "Die Therapie", 78);
    Book book4 = new Book("Fitzek Sebastian", "Elternabend", 85);
    Book book5 = new Book("Clive Bucher", "Mental Power", 68);

    books.add(book);
    books.add(book1);
    books.add(book2);
    books.add(book3);
    books.add(book4);
    books.add(book5);

    for (Book b : books) {
      System.out.println(b);
    }
    System.out.println();
    books.sort(new BookTitleComparator());
    for (Book b : books) {
      System.out.println(b);
    }
    System.out.println();
    books.sort(new BookNumberOfPagesComparator());
    for (Book b : books) {
      System.out.println(b);
    }
  }
}
