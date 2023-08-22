package Task63;

import java.util.Objects;

public class Book {

  private final String author;
  private final String title;
  private final int pages;

  public Book(String author, String title, int pages) {
    this.author = author;
    this.title = title;
    this.pages = pages;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public int getPages() {
    return pages;
  }

  // не обязательно для решения, но обязательно для проверки
  @Override
  public String toString() {
    return "Book{" +
        "author='" + author + '\'' +
        ", title='" + title + '\'' +
        ", pages=" + pages +
        '}';
  }

  // переопределение compareTo заставляет переопределить equals
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Book book)) {
      return false;
    }
    return pages == book.pages && author.equals(book.author) && title.equals(book.title);
  }

  // переопределение equals заставляет переопределить hashCode
  @Override
  public int hashCode() {
    return Objects.hash(author, title, pages);
  }
}