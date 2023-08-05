package Task53.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  @Test
  public void testToString() {
    Book book = new Book("Author", "BookTitle", 100);
    String expected = "Book{author='Author', bookTitle='BookTitle', numberOfPages=100}";
    assertEquals(expected, book.toString());
  }

  @Test
  public void testCompareTo() {
    Book book1 = new Book("Author", "BookTitle", 100);
    assertEquals(0, book1.compareTo(book1));
    Book book2 = new Book("Author", "BookTitle", 50);
    assertTrue(book1.compareTo(book2) > 0);
    assertTrue(book2.compareTo(book1) < 0);
    Book book3 = new Book("Author", "BookTitle", 200);
    assertTrue(book1.compareTo(book3) < 0);
    assertTrue(book3.compareTo(book1) > 0);
    Book book4 = new Book("Author", "BookTitle", 50);
    assertTrue(book1.compareTo(book4) > 0);
    assertTrue(book4.compareTo(book1) < 0);
  }
}