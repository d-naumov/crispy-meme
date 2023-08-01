package Task52;


public class Book {

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
}

