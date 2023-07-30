package Task50;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

  private static final String SEP = ":";
  private static final Map<String, String> slangDictionary = readFromTxt("res/dict.txt");

  private final String word;
  private final String slang;

  public Dictionary(String word, String slang) {
    this.word = word;
    this.slang = slang;
  }

  private static Map<String, String> readFromTxt(String wordName) {
    Map<String, String> result = new HashMap<>();
    File slangFile = new File(wordName);
    try {
      Scanner scanner = new Scanner(slangFile);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] cells = line.split(SEP);
        try {
          String word = cells[0];
          String slang = cells[1];
          if (!result.containsKey(word)) {
            result.put(word, slang);
          }
          result.get(word);
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
}
