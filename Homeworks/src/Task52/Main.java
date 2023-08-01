package Task52;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Задача 1
//Используйте класс Book (книга) из предыдущего домашнего задания.
//
//Создайте компаратор, который позволит сортировать книги по названию,
// при одинаковых названиях - по автору (и там, и там - по алфавиту).
//Задача 2* (не обязательно)
//Создайте компаратор, который позволит сортировать книги по убыванию количества страниц,
// а при совпадающем объёме - по названиям ("по возрастанию", по алфавиту).
public class Main {

  public static void main(String[] args) {

    List<Book> books = new ArrayList<>();

    try {
      Scanner scanner = new Scanner(new File("res/books.txt"));
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] arrays = line.split(", ");

        String author = arrays[0];
        String title = arrays[1];
        int page = Integer.parseInt(arrays[2]);

        Book book = new Book(author, title, page);
        books.add(book);
      }
      scanner.close();

      for (Book book : books) {
        System.out.println(
            book.getAuthor() + ", " + book.getBookTitle() + ", " + book.getNumberOfPages());
      }
      System.out.println();
      books.sort(new BookTitleComparator());
      for (Book book : books) {
        System.out.println(
            book.getAuthor() + ", " + book.getBookTitle() + ", " + book.getNumberOfPages());
      }
      System.out.println();
      books.sort(new BookNumberOfPagesComparator());
      for (Book book : books) {
        System.out.println(
            book.getAuthor() + ", " + book.getBookTitle() + ", " + book.getNumberOfPages());
      }
    } catch (FileNotFoundException e) {
      System.out.println("Файл не найден");
    }
  }
}
