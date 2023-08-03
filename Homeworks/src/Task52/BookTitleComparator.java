package Task52;

import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book> {

  @Override
  public int compare(Book o1, Book o2) {
    int result = o1.getBookTitle().compareTo(o2.getBookTitle());
    if (result != 0) {
      return result;
    }
    return o1.getAuthor().compareTo(o2.getAuthor());
  }
}
