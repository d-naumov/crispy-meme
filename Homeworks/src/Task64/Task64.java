package Task64;

import java.util.ArrayList;
import java.util.List;


//Задача 1
//Используйте класс Book из домашнего задания к уроку 53 (см. Book.java), но без интерфейса Comparable.
//
//Создайте список книг.
//
//Отсортируйте книги по автору, (при одинаковых авторах - по названиям) и выведите получившийся список с использованием потоков.
public class Task64 {

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

    books.stream()
        .sorted((o1, o2) -> {
          if (o1.getAuthor().compareTo(o2.getAuthor()) != 0) {
            return o1.getAuthor().compareTo(o2.getAuthor());
          }
          // сюда мы попадём, только если авторы совпали
          return o1.getTitle().compareTo(o2.getTitle());
        })
        .forEach(b -> System.out.println(b));
  }
}
