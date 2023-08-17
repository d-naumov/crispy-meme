package Task53;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Book is works:")
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

  @DisplayName("compareTo() is works:")
  @Nested
  class TestsForCompareTo {

    @Test
    public void same_book() {
      Book book1 = new Book("Author", "BookTitle", 100);
      assertEquals(0, book1.compareTo(book1)); // Сравнение с самим собой должно вернуть 0
    }

    @Test
    public void different_authors() {
      Book book1 = new Book("AuthorA", "BookTitle", 100);
      Book book2 = new Book("AuthorB", "BookTitle", 100);

      assertTrue(book1.compareTo(book2) < 0); // book1 должна быть меньше book2 по автору
      assertTrue(book2.compareTo(book1) > 0); // book2 должна быть больше book1 по автору
    }

    @Test
    public void same_authors_different_titles() {
      Book book1 = new Book("Author", "BookTitleA", 100);
      Book book2 = new Book("Author", "BookTitleB", 100);

      assertTrue(book1.compareTo(book2) < 0); // book1 должна быть меньше book2 по названию книги
      assertTrue(book2.compareTo(book1) > 0); // book2 должна быть больше book1 по названию книги
    }

    @Test
    public void same_authors_and_titles_different_pages() {
      Book book1 = new Book("Author", "BookTitle", 100);
      Book book2 = new Book("Author", "BookTitle", 200);

      assertTrue(
          book1.compareTo(book2) < 0); // book1 должна быть меньше book2 по количеству страниц
      assertTrue(
          book2.compareTo(book1) > 0); // book2 должна быть больше book1 по количеству страниц
    }
  }
}