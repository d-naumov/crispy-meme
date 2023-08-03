package Task52;


import java.util.Objects;

public class Book implements Comparable<Book> {

  private final String author;
  private final String bookTitle;
  private final int numberOfPages;

  public Book(String author, String bookTitle, int numberOfPages) {
    this.author = author;
    this.bookTitle = bookTitle;
    this.numberOfPages = numberOfPages;
  }

  public String getAuthor() {
    return author;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public int getNumberOfPages() {
    return numberOfPages;
  }

  @Override
  public String toString() {
    return "Book{" +
        "author='" + author + '\'' +
        ", bookTitle='" + bookTitle + '\'' +
        ", numberOfPages=" + numberOfPages +
        '}';
  }

  @Override
  public int compareTo(Book o) {
    if (!author.equals(o.author)) {
      return author.compareTo(o.author);
    }
    if (!bookTitle.equals(o.bookTitle)) {
      return bookTitle.compareTo(o.bookTitle);
    }
    return Integer.compare(numberOfPages, o.numberOfPages);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Book book = (Book) o;

    if (numberOfPages != book.numberOfPages) {
      return false;
    }
    if (!author.equals(book.author)) {
      return false;
    }
    return bookTitle.equals(book.bookTitle);
  }

  @Override
  public int hashCode() {

    return Objects.hash(author, bookTitle, numberOfPages);
  }
}

