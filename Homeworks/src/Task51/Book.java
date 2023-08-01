package Task51;


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
    int result = author.hashCode();
    result = 31 * result + bookTitle.hashCode();
    result = 31 * result + numberOfPages;
    return result;
  }
}
/* public static Map<String, Map<String, Integer>> readFromTxt(String filename) {
    Map<String, Map<String, Integer>> result = new HashMap<>();
    File bookFile = new File(filename);
    try {
      Scanner scanner = new Scanner(bookFile);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] cells = line.split(SEP);
        try {
          String author = cells[0];
          String bookTitle = cells[1];

          int numberOfPages = Integer.parseInt(cells[2]);
          if (!result.containsKey(author)) {
            result.put(author, new HashMap<>());
          }
          result.get(author).put(bookTitle, numberOfPages);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
          System.out.println("Некорректная строка файла: " + line);
        }
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Не найден файл: " + e);
    }
    return result;
  }

 */
