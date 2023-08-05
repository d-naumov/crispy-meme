package Task53.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Task53.Book;
import org.junit.jupiter.api.Test;

class BookTests {

  @Test
  public void testGetters() {
    Book book = new Book("Author", "BookTitle", 100);
    String author = "Author";
    String title = "BookTitle";
    int pages = 100;
    assertEquals(author, book.getAuthor());
    assertEquals(title, book.getBookTitle());
    assertEquals(pages, book.getNumberOfPages());

  }

}