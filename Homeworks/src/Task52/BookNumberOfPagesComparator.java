package Task52;

import java.util.Comparator;

public class BookNumberOfPagesComparator implements Comparator<Book> {

  @Override
  public int compare(Book o1, Book o2) {
    int result = Integer.compare(o1.getNumberOfPages(), o2.getNumberOfPages());
    if (result == 0) {
      result = o1.getBookTitle().compareTo(o2.getBookTitle());
    }
    return result;
  }
}
