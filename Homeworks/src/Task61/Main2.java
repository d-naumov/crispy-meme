package Task61;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Задача 2* (не обязательно)
//Дана последовательность слов (количество, а затем и сами слова, каждое слово с новой строки).
//
//Вывести все самые короткие слова через пробел.
//
//Оценить временную и пространственную сложность алгоритма.
public class Main2 {

  public static void main(String[] args) {          // time = O(n)    space = O(1)
    Scanner scanner = new Scanner(System.in);       // time = O(1), space = O(1)

    System.out.println("Введите количество слов: ");
    if (!scanner.hasNextInt()) {                    // time = O(1), space = O(1)
      System.out.println("Некорректная команда");   // time = O(1), space = O(1)
      scanner.close();                             // time = O(1), space = O(1)
      return;
    }
    int count = scanner.nextInt();             // time = O(1), space = O(1)

    scanner.nextLine();                        // time = O(1), space = O(1)
    if (count <= 0) {                          // time = O(1), space = O(1)
      System.out.println("Количество слов должно быть положительным!"); // time = O(1), space = O(1)
      scanner.close();                         // time = O(1), space = O(1)
      return;
    }
    List<String> shortestWords = new ArrayList<>();  // time = O(1), space = O(1)

    System.out.println("Введите слова:");

    String firstWord = scanner.nextLine();      // time = O(1), space = O(1)
    int minLength = firstWord.length();         // time = O(1), space = O(1)
    shortestWords.add(firstWord);               // time = O(1), space = O(1)

    for (int i = 0; i < count - 1; i++) {       // time = O(n), space = O(1)
      String word = scanner.nextLine();         // time = O(1), space = O(1)
      int wordLength = word.length();           // time = O(1), space = O(1)

      if (wordLength < minLength) {             // time = O(1), space = O(1)
        minLength = wordLength;                 // time = O(1), space = O(1)
        shortestWords.clear();                  // time = O(1), space = O(1)
        shortestWords.add(word);                // time = O(1), space = O(1)
      } else if (wordLength == minLength) {     // time = O(1), space = O(1)
        shortestWords.add(word);                // time = O(1), space = O(1)
      }
    }
    if (shortestWords.isEmpty()) {              // time = O(1), space = O(1)
      System.out.println("Нет коротких слов.");
    } else {
      System.out.println("Самые короткие слова:");
      for (String word : shortestWords) {       // time = O(n), space = O(1)
        System.out.print(" " + word);           // time = O(n), space = O(1)
      }
    }
    scanner.close();                           // time = O(1), space = O(1)
  }
}

