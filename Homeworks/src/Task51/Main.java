package Task51;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
      Collections.sort(books);

      for (Book book : books) {
        System.out.println(
            book.getAuthor() + ", " + book.getBookTitle() + ", " + book.getNumberOfPages());
      }
    } catch (FileNotFoundException e) {
      System.out.println("Файл не найден");
    }
  }
}
